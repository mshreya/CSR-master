import { Injectable } from '@angular/core';
import{HttpClient} from '@angular/common/http';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  

  constructor(private http: HttpClient) { }

  public getCurrentUser(){
    
    return this.http.get(`${baseUrl}/current-user`);
   }

//generate token

public generateToken(loginData: any){
  return this.http.post(`${baseUrl}/generate-token`,loginData);
}

//login user: set token in LocalStorage
public loginUser(token:any){
  localStorage.setItem("token",token);
  return true;
}

//isLogin: user is loggedin or not

public isLoggedIn(){
  let tokenstr=localStorage.getItem('token')
  if(tokenstr==undefined||tokenstr==''||tokenstr==null){
    return false
  }else{
    return true;
  }
}

//Logout

public logout(){
  localStorage.removeItem('token');
  localStorage.removeItem('user');
  return true;
}

//getToken
public getToken(){
  return localStorage.getItem('token');
}

public setUser(user:any){
  localStorage.setItem('user',JSON.stringify(user));
}

public getUser(){

  let userstr=localStorage.getItem('user');
  if(userstr!=null){
    return JSON.parse(userstr);
  }else{
    this.logout();
    return null;
  }
}

public getUserRole(){
  let user=this.getUser();
  return user.authorities[0].authority;
}

}



