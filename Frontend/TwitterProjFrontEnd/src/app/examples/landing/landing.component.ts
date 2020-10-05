import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { FormBuilder, FormGroup } from "@angular/forms";

import { SearchServiceService } from "../../services/search-service.service";
import { ReturnedTweets } from "../../shared/returenedTweets";
import { HttpErrorResponse, HttpResponse } from "@angular/common/http";

@Component({
  selector: "app-landing",
  templateUrl: "./landing.component.html",
  styleUrls: ["./landing.component.scss"],
})
export class LandingComponent implements OnInit {
  focus: any;
  focus1: any;
  optionValue: FormGroup;
  myDropDown: string;
  tweets: ReturnedTweets[];

  onChangeofOptions(newGov) {
    console.log(newGov);
    this.myDropDown = newGov;
  }

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private searchService: SearchServiceService
  ) {
    this.optionValue = this.formBuilder.group({
      twitterId: "",
      keyword: "",
      tagName: "",
      hashTag: "",
    });
  }

  ngOnInit() {}

  onSubmit(optionValue, selectedValue) {
    // Process submit here
    console.log(selectedValue);
    if (selectedValue == "Fetch_Tweets") {
      this.searchService
        .hashTagSearch(optionValue.hashTag)
        .subscribe((response: any) => {
          // alert(response);
          this.tweets = response;
          console.log(this.tweets);
        });
    } else if (selectedValue == "User_Timeline") {
      this.searchService
        .validateUsers(optionValue.twitterId)
        .subscribe((response: any) => {
          // alert(response);
          if (response == "Success") {
            this.router.navigate(["/home"]);
          } else if (response == "Error") {
            alert("Wrong EmailId or Password!");
          }
          this.tweets = response;
          console.log(this.tweets);
        });
    }
  }
}
