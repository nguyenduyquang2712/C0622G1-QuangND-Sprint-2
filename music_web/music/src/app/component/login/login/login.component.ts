import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {TokenService} from "../../../service/security/token.service";
import {AuthService} from "../../../service/security/auth.service";
import {Router} from "@angular/router";
import {MessageReponse} from "../../../model/security/message-reponse";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  rfLogin: FormGroup;
  constructor(private _formBuilder: FormBuilder,
              private _tokenService: TokenService,
              private _authService: AuthService,
              private _router: Router) { }

  ngOnInit(): void {
    this.getFormLogin();
  }
  getFormLogin() {
    this.rfLogin = this._formBuilder.group({
      username: ['', [Validators.required, Validators.minLength(3)]],
      password: ['', [Validators.required, Validators.minLength(5)]],
      rememberMe: [false]
    })
  }
  login() {
    this._authService.loginForm(this.rfLogin.value).subscribe(data => {

      if (data.token != undefined) {
        console.log(this.rfLogin.value.rememberMe)
        if (this.rfLogin.value.rememberMe) {
          this._tokenService.rememberMe(data.token, data.user, data.roles, data.username);
        } else {
          this._tokenService.setTokenSession(data.token);
          this._tokenService.setRoleSession(data.roles);
          this._tokenService.setUserSession(data.user);
          this._tokenService.setUserNameLocal(data.username);
        }
        this._router.navigate(['']).then(() => {
          window.location.reload();
        });
      }
    }, error => {
      const messageReponse: MessageReponse = error;
      if (messageReponse.message) {
        this._router.navigateByUrl('/login');
      }else{
        this._router.navigateByUrl('/login');
      }
    })
  }
}
