import { Pipe, PipeTransform } from '@angular/core';
import { Session } from './listsession.component';


@Pipe({
  name: 'flterSession'
})
export class FlterSessionPipe implements PipeTransform {

  transform( sessions:Session[], filter: string): any {

    return sessions ? sessions.filter(item => item.formation.search(new RegExp(filter, 'i')) > -1) : [];
  }

}
