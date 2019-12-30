import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Session } from 'src/app/listsession/listsession.component';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ListSessionAdminDataService {

  constructor(
    private http:HttpClient 
  ) { }


  
  retriveAllSession(){
    return this.http.get<Session[]>(`http://localhost:8202/sessions/all`);
 
    //console.log('hellow word service');
  }


  deleteSession(id){
    return this.http.delete<Session[]>(`http://localhost:8202/sessions/${id}`)
  }


  retriveSession(id){
    return this.http.get<Session>(`http://localhost:8202/sessions/${id}`);
 
  }

  updateSession(id,session){
    return this.http.put(`http://localhost:8202/sessions/${id}`,session);
 
  }

  createSession(session){
    return this.http.post(`http://localhost:8202/sessions`,session);
 
  }
  SaveSessionPhoto(fromData:FormData):Observable<any> {
    return this.http.post(`http://localhost:8202/SaveSessionServer`,fromData)
  }

 
  getImage():Observable<any> {
    return this.http.get(`http://localhost:8202/imageSession`)
  }
}
