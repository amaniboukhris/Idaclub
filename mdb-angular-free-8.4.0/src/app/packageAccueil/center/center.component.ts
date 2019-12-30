import { Component, OnInit, Input } from '@angular/core';
import { CommentaireService } from 'src/app/service/commentaire.service';
import { Comment } from 'src/app/model/comment';
import { ListSessionAdminDataService } from 'src/app/service/data/list-session-admin-data.service';
import { ListUserAdminDataService } from 'src/app/service/data/list-user-admin-data.service';

@Component({
  selector: 'app-center',
  templateUrl: './center.component.html',
  styleUrls: ['./center.component.scss']
})
export class CenterComponent implements OnInit {
  @Input() userid: any;
  messageLeft;

  public counter: number = 0;
  image
  @Input() idu: number;
  comments: any;
  sessions: any;
  @Input() message: String;
  comment: Comment = new Comment();
  newcomment = false;
  id;
  listSession;
  public show: boolean = false;
  public buttonName: any = 'Show';
  public images: any = [];
  imageUser;
  imagesUsers
   
   idUserSession:number;
  constructor(
    private commentService: CommentaireService, 
    private listeSessionService: ListSessionAdminDataService, 
    private listSessionAdminDataService: ListSessionAdminDataService,
    private listUserAdminDataService: ListUserAdminDataService,
    

    ) { }

  ngOnInit() {
    this.messageLeft=sessionStorage.getItem('iduser');
    this.idUserSession=+this.messageLeft;
    console.log("zzzzzzz"+this.idUserSession);

    this.Getsession();

    this.RefrechComment();
    this.listUserAdminDataService.getImage().subscribe(
      resp => { this.imagesUsers =resp
     this.imageUser=this.imagesUsers[this.messageLeft-1]  
 }
    );




  }
  Getsession() {
    this.listeSessionService.retriveAllSession().subscribe(data => {
      this.sessions = data;


      this.listSessionAdminDataService.getImage().subscribe(
        data => {
          this.images = data

        }

      );

    }, err => {

      console.log(err);
    });

  }
  RefrechComment() {
    this.commentService.getAll().subscribe(
      response => {
        this.comments = response;
        this.counter = this.comments.length;
      })
  };


  toggle(session) {
    session.show = !session.show;

    if (session.show) {
      this.buttonName = "Hide";

    }
    else {

      this.buttonName = "show";


    }
  }


  RefrechCommentSession(id) {
    this.commentService.getSessionComm(id).subscribe(
      response => {
        this.comments = response;
        console.log(response)
      })
  };




  addCommentToSession(id) {

    if (this.comment.message != '') {

      this.comment.date = new Date()
      this.comment.email = sessionStorage.getItem('autheticateruser');
      this.comment.iduser=this.idUserSession;


      this.commentService.add(id, this.comment).subscribe(data => {
        this.comments = data;
        this.comment.message = "";
        console.log(this.comment)
        this.counter = this.counter + 1
        this.ngOnInit();
      }, err => {

        console.log(err);
      });

    }
  }


  deletComment(idS, id,iduser) {
    console.log(idS)
    console.log(id)
    console.log(iduser)
    console.log(this.idUserSession)


  

    if (iduser===this.idUserSession){
    this.commentService.deletCommenttoSession(idS,id).subscribe(
      response => {
       
        this.comments = response;
        this.ngOnInit();
        
      })
      
         
    }else{
      console.log("tu peut pas supprimer ce commentaire!!")
    } 
  
  }



  reserverSession(ids,userid,session){
    console.log(ids);
  
    userid=this.idUserSession;
    console.log(userid);

    this.listUserAdminDataService.ajouterSession(userid,ids,session).subscribe(data=>{
      this.listSession=data;
      window.location.reload();

      

      },err=>{
   
       console.log(err);
      });
  
   

  }


  



}
