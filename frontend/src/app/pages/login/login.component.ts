import { Component, OnInit } from '@angular/core';
import{MatSnackBar } from '@angular/material/snack-bar';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginData={
    employeeId:"",
    password:"",
  };

  constructor(private snack:MatSnackBar,private login:LoginService) { }

  ngOnInit(): void {

  }

  formSubmit(){
    if(this.loginData.employeeId.trim()=='' || this.loginData.employeeId==null){
       this.snack.open("EmployeeId is required","",{
         duration:1000
       });
    
    return;  }

    if(this.loginData.password.trim()=='' || this.loginData.password==null){
      this.snack.open("Password is required","",{
        duration:1000
      });

   return;  }



  this.login.generateToken(this.loginData).subscribe(
(data:any)=>{
  console.log("success");
  console.log(data);

this.login.loginUser(data.token);
this.login.getCurrentUser().subscribe((user:any)=>{
    this.login.setUser(user);
    console.log(user);

    if(this.login.getUserRole()=="Admin"){
     window.location.href="./admin"
    }else if(this.login.getUserRole()=="Normal"){
     window.location.href="./normal"
    }else{
      this.login.logout();
    }});

},(error)=>{
  console.log("error");
  console.log(error);
  this.snack.open("Error ","",{
    duration:1000
  });
}

   )};
   
  
  }
