import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HTTP_INTERCEPTORS } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { LoginService } from "./login.service";


@Injectable()

export class AuthInterceptor implements HttpInterceptor{

    constructor(private login:LoginService){

    }
    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

        
        let modifiedReq:any='';
        // add the jwt token(Local Storage) request
        const token=this.login.getToken();
        if(token!=null){
        modifiedReq =req.clone({setHeaders:{'Authorization':`Bearer ${token}`}});
    
    }

        return next.handle(modifiedReq);
    }

}