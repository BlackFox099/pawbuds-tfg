import { IsString, IsOptional, IsDateString } from 'class-validator';

export class CrearDuenoDto {
  @IsString()
  nombre_completo: string;

  @IsString()
  @IsOptional()
  biografia?: string;

  @IsDateString()
  @IsOptional()
  fecha_nacimiento?: string;
}