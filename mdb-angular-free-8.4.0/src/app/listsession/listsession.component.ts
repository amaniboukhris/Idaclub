import { Component, OnInit, ViewChild, ElementRef, Input, Output, EventEmitter } from '@angular/core';
import { ListSessionAdminDataService } from '../service/data/list-session-admin-data.service';
import { Router, ActivatedRoute } from '@angular/router';
import * as XLSX from 'xlsx';  
import { CommentaireService } from '../service/commentaire.service';

export class Session{

  constructor(
    public id: number,
    public titre:string,
    public formation:string,
    public nbreHeures:string,
    public effectif:number,
    public programme:string,
    public prix:string


  ){

  }

}

@Component({
  selector: 'app-listsession',
  templateUrl: './listsession.component.html',
  styleUrls: ['./listsession.component.scss']
})
export class ListsessionComponent implements OnInit {
  userNameAdmin
  message:string;
  userPass
  public images :any=[];
  @Input()
  public sessions:Session[]
    searchModel: string;
    public sessioncurent :Session;
   @Output() public select: EventEmitter<{}> = new EventEmitter();
   comments;
   constructor(
    private router:Router,
    private route:ActivatedRoute,
    private listSessionAdminDataService: ListSessionAdminDataService,
    private commentService:CommentaireService

  ) { }

  ngOnInit() {

    this.userNameAdmin= this.route.snapshot.params['email'];
    this.RefrechSession();
  
  }
  @ViewChild('table', { static: false }) table: ElementRef;  
  title = 'Excel';  
  ExportTOExcel() {  
    const ws: XLSX.WorkSheet = XLSX.utils.table_to_sheet(this.table.nativeElement);  
    const wb: XLSX.WorkBook = XLSX.utils.book_new();  
    XLSX.utils.book_append_sheet(wb, ws, 'Sheet1');  
    XLSX.writeFile(wb, 'ListSessions.xlsx'); 

  }
 
  RefrechSession(){

    this.listSessionAdminDataService.retriveAllSession().subscribe(
      response =>{
    this.sessions=response;
    this.listSessionAdminDataService.getImage().subscribe(
    data => { this.images =data
      }
    );
   } )
  }

  deleteSession(id){
    console.log(`delete ${id}`)
    this.listSessionAdminDataService.deleteSession(id).subscribe(
      response =>{
     this.sessions=response;
     this.message = `Success! vous avez Supprimer La sessions ${id}` ;
     this.RefrechSession();

      })

    }
  updateSession(id){
      console.log(id);
      this.router.navigate(['sessback',id]);

    }
  addSession(){
        this.router.navigate(['sessback',-1]);
    }

    RefrechCommentSession(id){
      this.commentService.getSessionComm(id).subscribe(
        response => {
          this.comments = response;
          console.log(response)
        })
    };

    deletComment(idS, id) {
      //console.log(delete ${id})
      //if(this.comment.email!=sessionStorage.getItem('autheticateruser')){
      this.commentService.deletCommenttoSession(idS, id).subscribe(
        response => {
          this.comments = response;
          //this.message = Success! vous avez Supprimer ${id} ;
          //this.counter = this.counter - 1;
          this.ngOnInit();
  
  
        })
      err => {
  
        console.log(err);
      }
    }
 
}
