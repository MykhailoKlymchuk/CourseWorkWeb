export interface AirPollution {
  id: number;
  authorId: number;
  location: string;
  date: string;
  description: string;

  pm1: number;
  pm2_5: number;
  pm10: number;
  temperature: number;
  humidity: number;
  pressure: number;
}
