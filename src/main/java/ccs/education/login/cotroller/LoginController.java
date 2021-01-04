package ccs.education.login.cotroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class LoginController {
    @GetMapping(path = "/", produces = "text/html")
    public String top() {
    	// トップ画面
        return "Top";
    }
    @GetMapping(path = "/hello", produces = "text/html")
    public String hello() {
    	// Helloを表示する画面、初期状態では認証は必要ない設定
        return "Hello";
    }
    @GetMapping(path = "/success", produces = "text/html")
    public String success() {
    	// Successを表示する画面、初期状態では認証が必要な設定
        return "Success";
    }
}