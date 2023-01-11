import {AccountRole} from "./account-role";

export interface Role {
  id?: number;
  name?: string;
  accountRoles?: AccountRole[];
}
