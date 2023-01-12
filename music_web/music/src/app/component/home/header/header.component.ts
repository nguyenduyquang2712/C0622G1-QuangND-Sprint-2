import { Component, OnInit } from '@angular/core';
import {TokenService} from "../../../service/security/token.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  checklogin = false;
  role: string[];
  checkrole: number;
  constructor(
    private tokenService: TokenService,
    private router: Router
  ) { }

  ngOnInit(): void {
    if (this.tokenService.isLogged()) {
      this.checklogin = true;
      this.role = this.tokenService.getRole()
      for (let i = 0; i < this.role.length; i++) {
        if (this.role[i] === 'ROLE_USER') {
          this.checkrole= 0;
        }
        if (this.role[i] === 'ROLE_ADMIN') {
          this.checkrole= 1;
          break;
        }
      }
    }
  }

  logOut() {
    this.tokenService.logOut();
    this.router.navigateByUrl("/").then(() => {
      location.reload();
    })
  }
}
