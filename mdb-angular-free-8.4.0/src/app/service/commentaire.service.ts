import { Injectable } from '@angular/core';
import { HardcodedAuthentificationService } from './hardcoded-authentification.service';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class CommentaireService {

  constructor(private hardcodedauthentificationservice:HardcodedAuthentificationService ,private http:HttpClient) { }
  add( id,comment ){
    return this.http.post<Comment>(`http://localhost:8202/sessions/${id}/newcomment`,comment ); 
  }

getAll(){
    return this.http.get<Comment>(`http://localhost:8202/commentaire/all`); 
  }
 
  getSessionComm(id){
    return this.http.get<Comment>(`http://localhost:8202/sessions/${id}/commentaires`); 
  }
  deletCommenttoSession(idS,id){
    return this.http.delete<Comment[]>(`http://localhost:8202/sessions/${idS}/commentaire/${id}`)
  }
}
