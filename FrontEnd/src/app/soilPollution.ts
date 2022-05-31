export interface SoilPollution {
  id: number;
  authorId: number;
  location: string;
  date: string;
  description: string;

  pH: number;
  acidity: number;
  minerals: number;
  humidity: number;
}
