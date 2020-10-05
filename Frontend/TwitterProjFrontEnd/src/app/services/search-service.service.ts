import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
// import { UserDetails } from "../common/user-details";
import { Observable, observable } from "rxjs";
import { map } from "rxjs/operators";
import "rxjs/add/operator/map";
import { ReturnedTweets } from "../shared/returenedTweets";

@Injectable({
  providedIn: "root",
})
export class SearchServiceService {
  private baseUrl = "http://localhost:8080/tweets/userTimelines:";

  private modifiedUrl = "";

  constructor(private httpClient: HttpClient) {}

  public validateUsers(obj: String) {
    console.log(obj);

    this.modifiedUrl = this.baseUrl + obj;
    console.log(this.modifiedUrl);

    return this.httpClient
      .post(this.modifiedUrl, {
        headers: new HttpHeaders({
          "Content-Type": "application/json",
        }),
      })
      .map((data) => data);
  }

  public hashTagSearch(obj: String) {
    console.log(obj);

    this.modifiedUrl = "http://localhost:8080/tweets/hashTag:" + obj;
    console.log(this.modifiedUrl);

    return this.httpClient
      .post(this.modifiedUrl, {
        headers: new HttpHeaders({
          "Content-Type": "application/json",
        }),
      })
      .map((data) => data);
  }

  getProductList(): Observable<ReturnedTweets[]> {
    return this.httpClient
      .get<GetResponse>(this.modifiedUrl)
      .pipe(map((response) => response._embedded.tweets));
  }
}

interface GetResponse {
  _embedded: {
    tweets: ReturnedTweets[];
  };
}
