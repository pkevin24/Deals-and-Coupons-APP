import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { UserdetailsComponent } from './userdetails/userdetails.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { NewsComponent } from './news/news.component';
import {HttpClient, HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import {NewsapiserviceService} from './service/newsapiservice.service';

import { DealsComponent } from './deals/deals.component';
import { SignupComponent } from './signup/signup.component';
import { CouponsComponent } from './coupons/coupons.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AdminComponent } from './admin/admin.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { RouterModule } from '@angular/router';
import { AuthGuard } from './_auth/auth.guard';
import { AuthInterceptor } from './_auth/auth.interceptor';
import { UserService } from './service/user.service';
import { UpdateDealsComponent } from './update-deals/update-deals.component';
import { UpdateCouponsComponent } from './update-coupons/update-coupons.component';
import { CouponUserComponent } from './coupon-user/coupon-user.component';

import { DealUserComponent } from './deal-user/deal-user.component';
import { DemologinComponent } from './demologin/demologin.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { CouponsdealComponent } from './couponsdeal/couponsdeal.component';
import { AngularTypewriterEffectModule } from 'angular-typewriter-effect';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    UserdetailsComponent,
    LoginComponent,
    HomeComponent,
    NewsComponent,
    
    SignupComponent,

    DealsComponent,
    CouponsComponent,
    AdminComponent,
    ForbiddenComponent,
    UpdateDealsComponent,
    UpdateCouponsComponent,
    CouponUserComponent,

    DealUserComponent,
     DemologinComponent,
      CouponsdealComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    FontAwesomeModule,
    AngularTypewriterEffectModule
  ],
  providers: [
    AuthGuard,
    {
      provide:HTTP_INTERCEPTORS,
      useClass:AuthInterceptor,
      multi:true
    },UserService,
    HttpClient,
    NewsapiserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
