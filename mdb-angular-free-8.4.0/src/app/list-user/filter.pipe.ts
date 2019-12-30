import { Pipe, PipeTransform } from '@angular/core';
import { User } from './list-user.component';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {

  transform( users:User[], filterText: string): any {
    return users ? users.filter(item => item.prenom.search(new RegExp(filterText, 'i')) > -1) : [] ;


    //return users.filter((item) => {
    //return item.nom.search(filterText) || item.prenom.search(filterText) || item.adresse.search(filterText);
  //});
 
}
 
         
  

}
