import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  private readonly messageSubject = new BehaviorSubject<string | null>(null);
  
  message$ = this.messageSubject.asObservable(); // observable público

  setMessage(msg: string) {
    this.messageSubject.next(msg);
  }

  clearMessage() {
    this.messageSubject.next(null);
  }
}
