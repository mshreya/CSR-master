import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './pages/admin/admin.component';
import { LoginComponent } from './pages/login/login.component';
import { NormalComponent } from './pages/normal/normal.component';

const routes: Routes = [  {
  path:'',
  component:LoginComponent,
  pathMatch:"full"
},{
  path:'admin',
  component:AdminComponent,
  pathMatch:"full",
  //canActivate:[AdminGuard]
},
{
  path:'normal',
  component:NormalComponent,
  pathMatch:"full",
  //canActivate:[NormalGuard]
},];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
