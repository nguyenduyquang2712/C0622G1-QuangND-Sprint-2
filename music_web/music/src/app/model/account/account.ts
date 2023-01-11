import {AccountRole} from "./account-role";
import {User} from "../user/user";

export interface Account {
  id?: number;
  username?: string;
  accountRoles?: AccountRole[];
  user?: User;
}
