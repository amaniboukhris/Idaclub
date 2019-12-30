import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from 'src/app/list-user/list-user.component';
import { Session } from 'src/app/listsession/listsession.component';
import { Observable } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class ListUserAdminDataService {


  constructor(
    private http:HttpClient 
  ) { }


  retriveAllUsers(){
    return this.http.get<User[]>(`http://localhost:8202/users/all`);
  
    //console.log('hellow word service');
  }
  deleteUser(id){
    return this.http.delete<User[]>(`http://localhost:8202/users/${id}`)
 
  }
  retriveUser(id){
    return this.http.get<User>(`http://localhost:8202/users/${id}`);
 
  }

updateUser(id,users){
    return this.http.put(`http://localhost:8202/users/${id}`,users);
 
  }
  createUser(users){
    return this.http.post(`http://localhost:8202/users`,users);
 
  }
  deletSessionUser(idu,ids){
    return this.http.delete<User[]>(`http://localhost:8202/users/${idu}/Sessions/${ids}`);
 
  }
  onGetSessions(idu){
return this.http.get(`http://localhost:8202/users/${idu}/Sessions`)
  }
  ajouterSession(idu,ids,session){
    return this.http.post(`http://localhost:8202/users/${idu}/Sessions/${ids}`,session)
  }
  SaveUserProfil(fromData:FormData):Observable<any> {
    return this.http.post(`http://localhost:8202/SaveUserProfilServer`,fromData)
  }
  getImage():Observable<any> {
    return this.http.get(`http://localhost:8202/getimage`)
  }

  SendUserMail(userInscr){
    return this.http.post(`http://localhost:8202/sendmail`,userInscr);
 
  }

  GetUsersByEmail(email){
    return this.http.get<User>(`http://localhost:8202/user/${email}`);
 }
}










  
