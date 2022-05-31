import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {environment} from 'src/environments/environment';
import { UserComplaint } from './userComplaint';

@Injectable({
  providedIn: 'root'
})
export class UserComplaintService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {
  }

  public getUserComplaints(): Observable<UserComplaint[]> {
    return this.http.get<UserComplaint[]>(`${this.apiServerUrl}/complaint/all`);
  }

  public addUserComplaint(userComplaint: UserComplaint): Observable<UserComplaint> {
    return this.http.post<UserComplaint>(`${this.apiServerUrl}/complaint/add`, userComplaint);
  }

  public updateUserComplaint(userComplaint: UserComplaint): Observable<UserComplaint> {
    return this.http.put<UserComplaint>(`${this.apiServerUrl}/complaint/update`, userComplaint);
  }

  public deleteUserComplaint(userComplaintId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/complaint/delete/${userComplaintId}`);
  }
}
