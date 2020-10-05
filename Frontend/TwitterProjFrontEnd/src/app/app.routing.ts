import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { BrowserModule } from "@angular/platform-browser";
import { Routes, RouterModule } from "@angular/router";

import { ComponentsComponent } from "./components/components.component";
import { ProfileComponent } from "./examples/profile/profile.component";
import { SignupComponent } from "./examples/signup/signup.component";
import { LandingComponent } from "./examples/landing/landing.component";
import { NucleoiconsComponent } from "./components/nucleoicons/nucleoicons.component";

import { LandingPageComponent } from "./newComponents/landing-page/landing-page.component";

const routes: Routes = [
  { path: "", redirectTo: "landing", pathMatch: "full" },
  { path: "home", component: ComponentsComponent },
  { path: "user-profile", component: ProfileComponent },
  { path: "signup", component: SignupComponent },
  { path: "landing", component: LandingComponent },
  { path: "nucleoicons", component: NucleoiconsComponent },
  { path: "landingPage", component: LandingPageComponent },
];

@NgModule({
  imports: [
    CommonModule,
    BrowserModule,
    RouterModule.forRoot(routes, {
      useHash: true,
    }),
  ],
  exports: [],
})
export class AppRoutingModule {}
