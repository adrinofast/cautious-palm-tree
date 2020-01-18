import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HttpServiceService {

  apiURL: string = 'http://localhost:8080/home/';

  constructor(private httpClient :HttpClient) { }

  getRequest():Observable<any>
  {
    return this.httpClient.get(this.apiURL)

  }

  uploadFile(file:File , id:number) : Observable<any>
  { 
    let Imgurl = 'http://localhost:8080/detectMe';
    const formdata:FormData = new FormData();
    formdata.append('file',file);
    let name  =file.name;
    formdata.append('fileName',name);
    return this.httpClient.post(Imgurl, formdata);


  }

  getImage(): Observable<any> {
    let imageUrl = 'http://localhost:8080/getimages';
  return this.httpClient.get(imageUrl);
}

} 