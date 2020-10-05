import { Component, OnInit } from "@angular/core";
import { FormBuilder } from "@angular/forms";
import { Router } from "@angular/router";

// import { SearchServiceService } from "../../../app/services/search-service.service";

@Component({
  selector: "app-landing-page",
  templateUrl: "./landing-page.component.html",
  styleUrls: ["./landing-page.component.css"],
})
export class LandingPageComponent implements OnInit {
  loginForm: any;
  constructor(
    private formBuilder: FormBuilder,
    private router: Router
  ) // private searchService: SearchServiceService
  {
    this.loginForm = this.formBuilder.group({
      emailId: "",
      password: "",
    });
  }

  ngOnInit(): void {}

  onSubmit(loginForm) {
    // Process checkout data here
    // this.searchService
    //   .validateUsers(loginForm.emailId, loginForm.password)
    //   .subscribe((response) => {
    //     if (response == "Success") {
    //       this.router.navigate(["/bodyData"]);
    //     } else if (response == "Error") {
    //       alert("Wrong EmailId or Password!");
    //     }
    //     console.log(response);
    //   });
  }
}
