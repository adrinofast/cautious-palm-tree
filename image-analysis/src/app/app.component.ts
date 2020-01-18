import { Component } from '@angular/core';
import { Observable } from "rxjs";
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms'; 
import { facedetail } from "./FacedetailObj"; 

import { HttpServiceService } from '../app/http-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',

  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'image-analysis';

  selectedFiles: FileList;  
  currentFileUpload: File; 
  facedetails: Observable<facedetail []>;

  constructor(private _httpService : HttpServiceService,useF:FormBuilder)
{

}
spinner:boolean =false;
fo = {};
pha : string = "bfore";
 images :any[]; 
imgdtae : string="";
ngOnInit()
{
  


}

userForm = new FormGroup({
  name : new FormControl('',Validators.required),
  email : new FormControl('',[Validators.required,Validators.email]),
  image : new FormControl()
  
  })

  selectFile(event)
{
  const file = event.target.files.item(0);

  if(5>1)
  {
    var size = event.target.files[0].size;
    if(size>1000000)
    {
      this.selectedFiles = event.target.files
    }
    else{
       this.selectedFiles = event.target.files
    }
  }
}

AdminForm(AdminInformation)  
{  
  this.spinner= true;
 if(this.selectedFiles !=null)
 {
   this.currentFileUpload = this.selectedFiles[0];
   console.log(this.currentFileUpload);
   this._httpService.uploadFile(this.currentFileUpload, 12)
   .subscribe(
     res=>{
       //let result = res.json();
       this.spinner= false;
       //this.imgdtae = res;
       this.facedetails = res;
//       console.log(this.imgdtae);

     }
   )
 }
}
}