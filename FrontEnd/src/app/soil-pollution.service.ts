import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {environment} from 'src/environments/environment';
import {SoilPollution} from './soilPollution';

@Injectable({
  providedIn: 'root'
})
export class SoilPollutionService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {
  }

  public getSoilPollutions(): Observable<SoilPollution[]> {
    return this.http.get<SoilPollution[]>(`${this.apiServerUrl}/soil/all`);
  }

  public addSoilPollution(soilPollution: SoilPollution): Observable<SoilPollution> {
    return this.http.post<SoilPollution>(`${this.apiServerUrl}/soil/add`, soilPollution);
  }

  public updateSoilPollution(soilPollution: SoilPollution): Observable<SoilPollution> {
    return this.http.put<SoilPollution>(`${this.apiServerUrl}/soil/update`, soilPollution);
  }

  public deleteSoilPollution(soilPollutionId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/soil/delete/${soilPollutionId}`);
  }
}
