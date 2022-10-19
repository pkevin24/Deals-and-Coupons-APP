import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserdetailsComponent } from './userdetails/userdetails.component';
import { NewsComponent } from './news/news.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';

import { DealsComponent } from './deals/deals.component';
import { CouponsComponent } from './coupons/coupons.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { AdminComponent } from './admin/admin.component';
import { AuthGuard } from './_auth/auth.guard';
import { UpdateDealsComponent } from './update-deals/update-deals.component';
import { UpdateCouponsComponent } from './update-coupons/update-coupons.component';
import { CouponUserComponent } from './coupon-user/coupon-user.component';

import { DealUserComponent } from './deal-user/deal-user.component';
import { DemologinComponent } from './demologin/demologin.component';
import { CouponsdealComponent } from './couponsdeal/couponsdeal.component';


const routes: Routes = [
  {path:'',redirectTo:'home',pathMatch:'full'},
  {
    path:'login',
    component:DemologinComponent
  },
  {
    path:'home',
    component:HomeComponent
  },
  {
  path:'news',
  component:NewsComponent
  },
  {
  path:'admin/details',
  component:UserdetailsComponent,
  // canActivate:[AuthGuard], 
  // data:{roles:['Admin','User']} 
  },
  {

    path:'signup',
    component:SignupComponent
    },
    {
    
  path:'signup',
  component:SignupComponent
},
{
    path:'admin/deals',
  component:DealsComponent,
  canActivate:[AuthGuard], 
  data:{roles:['Admin']} 
  },
  {
    path:'admin/coupons',
  component:CouponsComponent,
  canActivate:[AuthGuard], 
  data:{roles:['Admin']} 
  },
  {
    path:'forbidden',
  component:ForbiddenComponent
  },
  {
    path:'admin',
    component:AdminComponent,
    canActivate:[AuthGuard], 
    data:{roles:['Admin']} 
  },
  {
    path:'couponsdeal/:id',
    component:CouponsdealComponent,
    canActivate:[AuthGuard], 
    data:{roles:['Admin']} 
  },
  {
    path:'admin/deals/:id',
    component:UpdateDealsComponent,
    canActivate:[AuthGuard], 
    data:{roles:['Admin']} 
  },
  {
    path:'admin/coupons/:id',
    component:UpdateCouponsComponent,
    canActivate:[AuthGuard], 
    data:{roles:['Admin']} 
  },
   
  {
    path:'coupons',
    component:CouponUserComponent
  },
  {
    path:'deals',
    component:DealUserComponent,
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
