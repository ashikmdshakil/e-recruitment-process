package com.swe.erecruitment.controller;

import com.swe.erecruitment.model.*;
import com.swe.erecruitment.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class ApplicationCOntroller {
    @Autowired
    private UserJpaRepository userRepo;
    @Autowired
    private Roles role;
    @Autowired
    private CircularJpaRepository circularRepo;
    @Autowired
    private ExperienceJpaRepo experienceJpaRepo;
    @Autowired
    private EducationJpaRepo educationJpaRepo;
    @Autowired
    private CertificationJpaRepo certificationJpaRepo;
    @Autowired
    private EvalutionJpaRepo evalutionJpaRepo;

    @GetMapping("/")
    public String getHomePage(){
        return "index.html";
    }

    @PostMapping(value = "signupUser", consumes = "application/json")
    @ResponseBody
    public String signUpUser(@RequestBody Users user){
        String status ;
        try {
            role.setId(1);
            user.setRole(role);
            role.getUsers().add(user);
            userRepo.save(user);
            status = "success";
        } catch (Exception e) {
            e.printStackTrace();
            status = "failed";
        }
        return status;
    }
    @PostMapping(value = "signupAdmin", consumes = "application/json")
    @ResponseBody
    public String signUpAdmin(@RequestBody Users user){
        String status ;
        try {
            role.setId(2);
            user.setRole(role);
            role.getUsers().add(user);
            userRepo.save(user);
            status = "success";
        } catch (Exception e) {
            e.printStackTrace();
            status = "failed";
        }
        return status;
    }

    @GetMapping(value = "signIn")
    @ResponseBody
    public Principal signIn(Principal userToken){
        return userToken;
    }

    @GetMapping("getUserByEmail")
    @ResponseBody
    public Users getUserByEmail(@RequestParam("email") String email){
        return userRepo.findByEmail(email);
    }

    @GetMapping("getUserById")
    @ResponseBody
    public Users getUserById(@RequestParam("id") int id){
        return userRepo.findById(id);
    }

    @PostMapping(value = "createCircular", consumes = "application/json")
    @ResponseBody
    public HashMap<String, String> createCircular(@RequestBody Circular circular){
        HashMap<String, String> response = new HashMap<>();
        try {
            circular.setStartTime(new Date());
            int randomPIN = (int)(Math.random()*9000)+1000;
            String val = ""+randomPIN+""+circular.getOwner().getId();
            circular.setToken(val);
            circularRepo.save(circular);
            response.put("status","success");
            response.put("token",val);
        } catch (Exception e) {
            e.printStackTrace();
            response.put("status","failed");
        }
        return response;
    }

    @GetMapping("adminGetsCirculars")
    @ResponseBody
    public List<Circular> adminGetsCirculars(@RequestParam("id") int id){
        return circularRepo.findByOwnerIdOrderByDeadTimeAsc(id);
    }

    @GetMapping("getCircular")
    @ResponseBody
    public Circular getCircular(@RequestParam("token") String token){
        return circularRepo.findByToken(token);
    }

    @GetMapping("getCircularById")
    @ResponseBody
    public Circular getCircularById(@RequestParam("id") int id){
        return circularRepo.findById(id);
    }

    @PostMapping(value = "addExperience", consumes = "application/json")
    @ResponseBody
    public String addExperience(@RequestBody Experience experience){
        String status;
        try {
            experienceJpaRepo.save(experience);
            status = "success";
        } catch (Exception e) {
            e.printStackTrace();
            status = "failed";
        }
        return status;
    }

    @GetMapping("getExperiences")
    @ResponseBody
    public List<Experience> getExperiences(@RequestParam("id") int id){
        return experienceJpaRepo.findByUserId(id);
    }

    @PostMapping(value = "addEducation", consumes = "application/json")
    @ResponseBody
    public String addEducation(@RequestBody Education education){
        String status;
        try {
            educationJpaRepo.save(education);
            status = "success";
        } catch (Exception e) {
            e.printStackTrace();
            status = "failed";
        }
        return status;
    }
    @GetMapping("getEducations")
    @ResponseBody
    public List<Education> getEducations(@RequestParam("id") int id){
        return educationJpaRepo.findByUserId(id);
    }

    @PostMapping(value = "addCertification", consumes = "application/json")
    @ResponseBody
    public String addCertification(@RequestBody Certifications certification){
        String status;
        try {
            certificationJpaRepo.save(certification);
            status = "success";
        } catch (Exception e) {
            e.printStackTrace();
            status = "failed";
        }
        return status;
    }

    @GetMapping("getCertifications")
    @ResponseBody
    public List<Certifications> getCertifications(@RequestParam("id") int id){
        return certificationJpaRepo.findByUserId(id);
    }

    @PostMapping(value = "updateCV",consumes = "application/json")
    @ResponseBody
    public String updateCV(@RequestBody Users user){
        String status = null;
        try {
            userRepo.save(user);
            status = "success";
        } catch (Exception e) {
            e.printStackTrace();
            status = "failed";
        }
        return status;
    }

    @PostMapping(value = "applyJob",consumes = "application/json")
    @ResponseBody
    public String applyJob(@RequestBody Circular circular){
        String status = null;
        try {
            circularRepo.save(circular);
            status = "success";
        } catch (Exception e) {
            e.printStackTrace();
            status = "failed";
        }
        return status;
    }

    @PostMapping(value = "saveEvalution",consumes = "application/json")
    @ResponseBody
    public String saveEvalution(@RequestBody Evalution evalution){
        String status = null;
        try {
            evalutionJpaRepo.save(evalution);
            status = "success";
        } catch (Exception e) {
            e.printStackTrace();
            status = "failed";
        }
        return status;
    }

    @GetMapping("getEvalution")
    @ResponseBody
    public Evalution getEvalution(@RequestParam("aId") int aId, @RequestParam("cId") int cId){
        return evalutionJpaRepo.findByApplicantIdAndCircularId(aId,cId);
    }

    @GetMapping("getSortedEvalution")
    @ResponseBody
    public List<Evalution> getEvalutions(@RequestParam("cId") int cId){
        return evalutionJpaRepo.findByCircularIdOrderByMarks(cId);
    }

}
