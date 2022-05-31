import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {environment} from 'src/environments/environment';
import {AirPollution} from './airPollution';

@Injectable({
  providedIn: 'root'
})
export class AirPollutionService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {
  }

  public getAirPollutions(): Observable<AirPollution[]> {
    return this.http.get<AirPollution[]>(`${this.apiServerUrl}/air/all`);
  }

  public addAirPollution(airPollution: AirPollution): Observable<AirPollution> {
    return this.http.post<AirPollution>(`${this.apiServerUrl}/air/add`, airPollution);
  }

  public updateAirPollution(airPollution: AirPollution): Observable<AirPollution> {
    return this.http.put<AirPollution>(`${this.apiServerUrl}/air/update`, airPollution);
  }

  public deleteAirPollution(airPollutionId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/air/delete/${airPollutionId}`);
  }
}
