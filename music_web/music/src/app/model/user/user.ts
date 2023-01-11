export interface User {
  id?: number;
  city?: string;
  street?: string;
  zip?: string;
  firstName?:string;
  lastName?: string;
  gender?: number;
  phoneNumber?: string;
  email?:string;
  deleteStatus?: number;
  playList?: any;
  payment?: any;
}
