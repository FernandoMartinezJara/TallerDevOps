<template>
    <v-layout>
        <v-flex>
             <v-toolbar flat color="white">
                <v-toolbar-title>Preguntas</v-toolbar-title>
                <v-divider
                    class="mx-2"
                    inset
                    vertical
                ></v-divider>
                <v-spacer></v-spacer>
                
                <v-text-field class="text-xs-center" v-model="search" append-icon="search" label="Búsqueda de Preguntas" single-line hide-details>
                </v-text-field>

                <v-spacer></v-spacer>

                <v-dialog v-model="dialog" max-width="500px">
                    <!-- <v-btn slot="activator" color="primary" dark class="mb-2">Nueva Pregunta</v-btn> -->
                    <v-card>
                    <v-card-title>
                        <span class="headline">{{ formTitle }}</span>
                    </v-card-title>

                    <v-card-text>
                        <v-container grid-list-md>
                        <v-layout wrap>
                            <v-flex xs12 sm12 md12>
                                <v-text-field v-model="pregunta" label="Pregunta"></v-text-field>
                            </v-flex>
                            <v-flex xs12 sm12 md12>
                                <v-text-field v-model="codigo" label="Código"></v-text-field>
                            </v-flex>
                            <v-flex xs12 sm12 md12 v-show="valida">
                                <div class="red-text" v-for="v in validaMensaje" :key="v" v-text="v">
                                </div>
                            </v-flex>
                        </v-layout>
                        </v-container>
                    </v-card-text>

                    <v-card-actions>
                        <v-spacer></v-spacer>
                        <v-btn color="blue darken-1" flat @click="close">Cancelar</v-btn>
                        <v-btn color="blue darken-1" flat @click="save">Guardar</v-btn>
                    </v-card-actions>
                    </v-card>
                </v-dialog>
                </v-toolbar>

                <v-data-table
                    :headers="headers"
                    :items="preguntas"
                    :search="search"
                    class="elevation-1"
                >
                <template slot="items" slot-scope="props">
                    <td>{{ props.item.id }}</td>
                    <td>{{ props.item.pregunta }}</td>
                    <td>{{ props.item.codigo }}</td>

                </template>
                <template slot="no-data">
                    <v-btn color="primary" @click="listar">Reset</v-btn>
                </template>
                </v-data-table>
        </v-flex>
    </v-layout>
</template>

<script>
    import axios from 'axios'
    export default {
        data(){
            return{
                preguntas:[],
                dialog: false,
                headers: [
                { text: 'Id', value: 'id' },
                { text: 'Pregunta', value: 'pregunta' },
                { text: 'Código', value: 'codigo' },
                ],
                search: '',
                editedIndex: -1,
                editedItem: {
                    id: '',
                    pregunta: '',
                    codigo: '',
                },
                id:'',
                pregunta:'',
                codigo:'',
                valida: 0,
                validaMensaje:[]
            }
        },
        computed: {
            formTitle () {
                return this.editedIndex === -1 ? 'Nueva Pregunta' : 'Editar Pregunta'
            }
        },
        watch: {
            dialog (val) {
            val || this.close()
            }
        },  
        created () {
            this.listar();
        },
        methods:{
            
            listar(){
                let me=this;
                axios.get('listaEjercicios').
                then(function(response){
                    me.preguntas = response.data;
                }).
                catch(function(error){
                    console.log(error);
                })
            },
            editItem (item) {
                this.valida = 0;
                this.validaMensaje = [];
                this.editedIndex = this.preguntas.indexOf(item);
                this.editedItem = Object.assign({}, item);
                this.dialog = true;
            },

            deleteItem (item) {
                const index = this.preguntas.indexOf(item)
                confirm('Está seguro de Eliminar Pregunta?') && this.preguntas.splice(index, 1)
            },
            
            close () {
                this.dialog = false
                setTimeout(() => {
                    this.editedItem = Object.assign({}, this.defaultItem)
                    this.editedIndex = -1
                }, 300)
            },

            limpiar(){
                this.id = "";
                this.titulo = "";
                this.codigo = "";
            },

            save () {
                // if(this.validar()){
                //     return;
                // }
                if (this.editedIndex > -1) {
                    //Editar
                    Object.assign(this.preguntas[this.editedIndex], this.editedItem)
                } else {
                    //Guardar
                    //this.preguntas.push(this.editedItem)

                    let me = this;

                    axios.post('insertarEjercicio',{
                        'pregunta':me.pregunta,
                        'codigo':me.codigo
                    }).
                    then(function(response){
                        me.listar();
                        me.limpiar();
                        me.close();
                    }).catch(function(error){

                    });
                }
                this.close()

            },
            validar(){
                this.valida = 0;
                this.validaMensaje = [];

                if(this.categoria.length < 2 || 
                this.categoria.length > 50){
                    this.validaMensaje.push("La categoría debe tener más de 5 caracteres y menos que 50")
                }
                if(this.descripcion.length < 5 || 
                this.descripcion.length > 50){
                    this.validaMensaje.push("La descripción debe tener más de 5 caracteres y menos que 50")
                }
                if(this.descripcion.length < 1  || 
                this.descripcion.length > 50){
                    this.validaMensaje.push("La respuesta debe tener más de 1 caracteres y menos que 50")
                }
                if(this.validaMensaje.length){
                    this.valida = 1
                }
                return this.valida;
            }
        }
    }
</script>
