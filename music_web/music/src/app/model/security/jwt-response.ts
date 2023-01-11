import {User} from "../user/user";

export interface JwtResponse {
  token?: string;
  roles?: any;
  username?: string;
  user?: User;
}
