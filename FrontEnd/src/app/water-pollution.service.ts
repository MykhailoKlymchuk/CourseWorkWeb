import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {environment} from 'src/environments/environment';
import {WaterPollution} from './waterPollution';


@Injectable({
  providedIn: 'root'
})
export class WaterPollutionService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {
  }

  public getWaterPollutions(): Observable<WaterPollution[]> {
    return this.http.get<WaterPollution[]>(`${this.apiServerUrl}/water/all`);
  }

  public addWaterPollution(waterPollution: WaterPollution): Observable<WaterPollution> {
    return this.http.post<WaterPollution>(`${this.apiServerUrl}/water/add`, waterPollution);
  }

  public updateWaterPollution(waterPollution: WaterPollution): Observable<WaterPollution> {
    return this.http.put<WaterPollution>(`${this.apiServerUrl}/water/update`, waterPollution);
  }

  public deleteWaterPollution(waterPollutionId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/water/delete/${waterPollutionId}`);
  }
}
