import { Component, OnInit } from '@angular/core';
import { MDBModalRef } from 'angular-bootstrap-md';


@Component({
  selector: 'app-modal-inscription-reussite',
  templateUrl: './modal-inscription-reussite.component.html',
  styleUrls: ['./modal-inscription-reussite.component.scss']
})
export class ModalInscriptionReussiteComponent implements OnInit {

  constructor(public modalRef: MDBModalRef) { }

  ngOnInit() {
  }

}
