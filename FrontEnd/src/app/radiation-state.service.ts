import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {environment} from 'src/environments/environment';
import {RadiationState} from './radiationState';

@Injectable({providedIn: 'root'})
export class RadiationStateService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {
  }

  public getRadiationStates(): Observable<RadiationState[]> {
    return this.http.get<RadiationState[]>(`${this.apiServerUrl}/radiation/all`);
  }

  public addRadiationState(radiationState: RadiationState): Observable<RadiationState> {
    return this.http.post<RadiationState>(`${this.apiServerUrl}/radiation/add`, radiationState);
  }

  public updateRadiationState(radiationState: RadiationState): Observable<RadiationState> {
    return this.http.put<RadiationState>(`${this.apiServerUrl}/radiation/update`, radiationState);
  }

  public deleteRadiationState(radiationStateId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/radiation/delete/${radiationStateId}`);
  }
}
