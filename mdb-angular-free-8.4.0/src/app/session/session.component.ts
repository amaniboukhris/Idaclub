import { Component, OnInit } from '@angular/core';
import { Session } from '../listsession/listsession.component';
import { ListSessionAdminDataService } from '../service/data/list-session-admin-data.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ListUserAdminDataService } from '../service/data/list-user-admin-data.service';

@Component({
  selector: 'app-session',
  templateUrl: './session.component.html',
  styleUrls: ['./session.component.scss']
})
export class SessionComponent implements OnInit {
  id: number
  sess :Session
  
  public sessionFile: any=File;


  constructor(
    private sessionService :ListSessionAdminDataService,
private route : ActivatedRoute,
private router: Router,
  ) { }

  ngOnInit() {
    this.id=this.route.snapshot.params['id'];
    this.sess=new Session(this.id,"","","",0,"","");
    
    
    if(this.id!=-1){

    this.sessionService.retriveSession(this.id)
    .subscribe (
       data => this.sess=data

    )
    }
  }


  OnSelectFile(event){
    const file= event.target.files[0];
    this.sessionFile = file;
console.log(file)
  }


  saveSession(){
    if (this.id === -1) {
    // Create TODO
    this.sessionService.createSession(this.sess)
.subscribe(
  data => {
    const photo= data;
    const fformData =new FormData ();
         fformData.append('photo', JSON.stringify (photo))
          fformData.append('files',this.sessionFile)
          this.sessionService.SaveSessionPhoto(fformData).subscribe(
            response => {
              console.log(response);
        }
        )
    console.log(data);
    this.router.navigate(['sessions/nermine'])

  }
)
    }else{
this.sessionService.updateSession(this.id,this.sess)
.subscribe(
  data => {
    const photo= data;
    const fformData =new FormData ();
         fformData.append('photo', JSON.stringify (photo))
          fformData.append('files',this.sessionFile)
          this.sessionService.SaveSessionPhoto(fformData).subscribe(
            response => {
              console.log(response);
        }
        )
    console.log(data);
    this.router.navigate(['sessions/nermine'])

  }
)
    }
}





}


