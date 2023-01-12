import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router} from '@angular/router';
import { Observable } from 'rxjs';
import {TokenService} from "../../service/security/token.service";

@Injectable({
  providedIn: 'root'
})
export class UserGuard implements CanActivate {
  role: string[];
  constructor(
    private tokenService: TokenService,
    private route: Router
  ) {
  }
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if (this.tokenService.isLogged()) {
      this.role = this.tokenService.getRole()

      for (let i = 0; i < this.role.length; i++) {
        if (this.role[i] === 'ROLE_USER') {
          return true;
        }
      }

      console.log('Ban khong co quyen vao day')

    } else {
      console.log("dang nhap vo")
      this.route.navigateByUrl('/');
    }
  }

}
