export interface WaterPollution {
  id: number;
  authorId: number;
  location: string;
  date: string;
  description: string;

  pH: number;
  density: number;
  hardness: number;
  sulfates: number;
  chlorides: number;
  copper: number;
  manganese: number;
  iron: number;
  chlorophenol: number;
}
