import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { PrismaModule } from './prisma/prisma.module';
import { AuthModule } from './auth/auth.module';
import { UsuariosModule } from './usuarios/usuarios.module';
import { SwipesModule } from './swipes/swipes.module';
import { ChatModule } from './chat/chat.module';

@Module({
  imports: [PrismaModule, AuthModule, UsuariosModule, SwipesModule, ChatModule],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}
