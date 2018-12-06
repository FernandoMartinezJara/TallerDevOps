<template>
  <v-layout>
    <v-flex>
    <div lg12 class="pa-2">
      <v-card>
          <v-container fill-height fluid>
            <v-layout fill-height>
              <v-flex xs12 align-end flexbox>
                <span class="headline">{{pregunta}}</span>
              </v-flex>
            </v-layout>
          </v-container>

          <v-container fill-height fluid>
            <v-layout fill-height>
              <v-flex xs12 align-end flexbox>
                <span>{{codigo}}</span>
              </v-flex>
            </v-layout>
          </v-container>

          <v-container fill-height fluid>
            <v-layout fill-height>
          <v-flex xs12 sm12 md12>
            <v-text-field v-model="respuestaConfirm" label="Ingrese repuesta..."></v-text-field>
          </v-flex>
            </v-layout>
          </v-container>

        <v-card-actions>
            <v-flex xs9 >          
              <div v-show="respuestaInvalida" class="red-text" v-for="v in validaMensajes" :key="v" v-text="v">
              </div>                        
            </v-flex>

            <v-flex xs3>
                <div class="text-xs-right">
                  <v-btn color="success" @click="validarRespuesta">Responder</v-btn>
                </div>
            </v-flex>
        </v-card-actions>

      </v-card>
    </div>

    </v-flex>

  </v-layout>
</template>

<script>
import axios from 'axios'
export default {
  data(){
    return{
      preguntas:[],
      id :'',
      pregunta:'',
      codigo:'',
      respuesta:'',
      respuestaConfirm:'',
      respuestaInvalida : 0,
      validaMensajes:[]
    }
  },
  created(){
    this.listar();
  },
  methods:{
    limpiar(){
      this.respuestaConfirm = "";
    },
    listar(){
      let me=this;
       axios.get('recuperarEjercicio').
       then(function(response){
         console.log(response)
         me.pregunta= response.data.pregunta;
         me.id = response.data.id;
         me.codigo = response.data.codigo;
        }).
       catch(function(error){
            console.log(error);
        })
    },
    validarRespuesta(){

      let me = this;
      this.validaMensajes= [];
      let respuesta='';

      if(this.respuestaConfirm == "")
      {
        this.validaMensajes.push('Debe ingresar una respuesta.')
        this.respuestaInvalida = 1;
        return;
      }
       else
      {
        let respuesta= axios.post('validarEjercicios',{
          'id': me.id,
          'respuesta': me.respuestaConfirm
        }).
        then(result => 
        { 
          return result.data 
        }).catch(function(error){
      });

    respuesta.then(data => {
      console.log(data)
      if(data.esCorrecto == false)
        {
          this.validaMensajes.push('La respuesta que has ingresado es incorrecta. La respuesta es: ' + data.valor);
          this.respuestaInvalida = 1;
        }
        else
        {
          alert("Respuesta Correcta!!!")
          this.limpiar();
          this.listar();
        }})
    }
    }   
  }
}
</script>
