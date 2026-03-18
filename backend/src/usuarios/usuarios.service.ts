import { Injectable } from '@nestjs/common';
import { CreateUsuarioDto } from './dto/create-usuario.dto';
import { UpdateUsuarioDto } from './dto/update-usuario.dto';
import { PrismaService } from '../prisma/prisma.service';

@Injectable()
export class UsuariosService {
  constructor(private prisma: PrismaService) {}

  async obtenerDuenos() {
    return this.prisma.dueno.findMany({
      include: {
        usuario: true,
        perros: true,
      },
    });
  }

  async obtenerDuenoPorId(id: string) {
    return this.prisma.dueno.findUnique({
      where: { id: id },
      include: {
        perros: true,
      },
    });
  }

  // create(createUsuarioDto: CreateUsuarioDto) {
  //   return 'This action adds a new usuario';
  // }

  // findAll() {
  //   return `This action returns all usuarios`;
  // }

  // findOne(id: number) {
  //   return `This action returns a #${id} usuario`;
  // }

  // update(id: number, updateUsuarioDto: UpdateUsuarioDto) {
  //   return `This action updates a #${id} usuario`;
  // }

  // remove(id: number) {
  //   return `This action removes a #${id} usuario`;
  // }
}
