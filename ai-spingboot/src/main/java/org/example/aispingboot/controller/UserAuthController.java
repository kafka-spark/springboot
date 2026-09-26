package org.example.aispingboot.controller;

import org.example.aispingboot.common.Result;
import org.example.aispingboot.util.JwtTokenUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

// 接收前端账号密码
class LoginDTO{
    private String username;
    private String password;
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
}

// 返回给前端：token + userInfo
class LoginVO{
    private String token;
    private Map<String,Object> userInfo;
    public String getToken() {return token;}
    public void setToken(String token) {this.token = token;}
    public Map<String,Object> getUserInfo() {return userInfo;}
    public void setUserInfo(Map<String,Object> userInfo) {this.userInfo = userInfo;}
}

@RestController
@RequestMapping("/api/auth")
public class UserAuthController {

    @PostMapping("/login")
    public Result<LoginVO> login(@RequestBody LoginDTO loginDTO){
        // 写死账号密码
        String correctUser = "564641911@qq.com";
        String correctPwd = "123456";

        if(correctUser.equals(loginDTO.getUsername()) && correctPwd.equals(loginDTO.getPassword())){
            Long userId = 1L;
            String username = loginDTO.getUsername();
            Integer role = 1; //1普通用户
            String token = JwtTokenUtil.generateToken(userId, username, role);

            LoginVO vo = new LoginVO();
            vo.setToken(token);
            Map<String,Object> userInfo = new HashMap<>();
            userInfo.put("userType",1);
            userInfo.put("username",loginDTO.getUsername());
            vo.setUserInfo(userInfo);
            return Result.ok(vo);
        }else{
            // 3参数：code，msg，data(null)
            return Result.error("400","账号密码错误", null);
        }
    }
}












//package org.example.aispingboot.controller;
//
//
//
//import org.example.aispingboot.common.Result;
//import org.example.aispingboot.util.JwtTokenUtil;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import java.util.HashMap;
//import java.util.Map;
//
//// 接收前端账号密码
//class LoginDTO{
//    private String username;
//    private String password;
//    public String getUsername() {return username;}
//    public void setUsername(String username) {this.username = username;}
//    public String getPassword() {return password;}
//    public void setPassword(String password) {this.password = password;}
//}
//
//// 返回给前端：token + userInfo
//class LoginVO{
//    private String token;
//    private Map<String,Object> userInfo;
//    public String getToken() {return token;}
//    public void setToken(String token) {this.token = token;}
//    public Map<String,Object> getUserInfo() {return userInfo;}
//    public void setUserInfo(Map<String,Object> userInfo) {this.userInfo = userInfo;}
//}
//
//@RestController
//@RequestMapping("/api/user")
//public class UserAuthController {
//
//    @PostMapping("/login")
//    public Result<LoginVO> login(@RequestBody LoginDTO loginDTO){
//        // 写死账号密码，和前端表单输入一致
//        String correctUser = "564641911@qq.com";
//        String correctPwd = "123456";
//
//        if(correctUser.equals(loginDTO.getUsername()) && correctPwd.equals(loginDTO.getPassword())){
//            Map<String, Object> claims = new HashMap<>();
//            claims.put("userId", 1L);
//            String token = JwtTokenUtil.generateToken(claims);
//
//            LoginVO vo = new LoginVO();
//            vo.setToken(token);
//            Map<String,Object> userInfo = new HashMap<>();
//            userInfo.put("userType",1); //1普通用户，2管理员，控制前端页面跳转
//            userInfo.put("username",loginDTO.getUsername());
//            vo.setUserInfo(userInfo);
//            return Result.ok(vo);
//        }else{
//            return Result.fail("账号密码错误");
//        }
//    }
//}
