<template>
  <v-app id="inspire">

    <v-navigation-drawer
      :clipped="$vuetify.breakpoint.lgAndUp"
      v-model="drawer"
      fixed
      app
    >
      <v-list dense>
        <template>
         <v-list-tile :to="{name:'home'}">
          <v-list-tile-action>
            <v-icon>home</v-icon>
          </v-list-tile-action>
          <v-list-tile-title>
            home
          </v-list-tile-title>
         </v-list-tile>
        </template>

        <template>
         <v-list-group>

           <v-list-tile slot="activator">
            <v-list-tile-content>
              <v-list-tile-title>
                Preguntas
              </v-list-tile-title>
            </v-list-tile-content>
           </v-list-tile>

          <v-list-tile :to="{name: 'CrearPregunta'}">
            <v-list-tile-action>
              <v-icon>table_chart</v-icon>
            </v-list-tile-action>
            <v-list-tile-content>
              <v-list-tile-title>
                Crear Pregunta
              </v-list-tile-title>
            </v-list-tile-content>
          </v-list-tile>
          
          <v-list-tile :to="{name: 'ResponderPreguntas'}">
            <v-list-tile-action>
              <v-icon>table_chart</v-icon>
            </v-list-tile-action>
            <v-list-tile-content>
              <v-list-tile-title>
                Responder Preguntas
              </v-list-tile-title>
            </v-list-tile-content>
          </v-list-tile>

         </v-list-group>
        </template>

      </v-list>
    </v-navigation-drawer>

    <v-toolbar
      :clipped-left="$vuetify.breakpoint.lgAndUp"
      color="blue darken-3"
      dark
      app
      fixed
    >
      <v-toolbar-title style="width: 300px" class="ml-0 pl-3">
        <v-toolbar-side-icon @click.stop="drawer = !drawer"></v-toolbar-side-icon>
        <span class="hidden-sm-and-down">Taller DevOps</span>
      </v-toolbar-title>

      <v-spacer></v-spacer>
      <v-btn icon>
        <v-icon>apps</v-icon>
      </v-btn>
    </v-toolbar>
    
    <v-content>
      <v-container fluid fill-height>
        <v-slide-y-transition mode="out-in">
          <router-view/>
        </v-slide-y-transition>
      </v-container>
    </v-content>

    <v-footer dark height="auto">
      <v-layout justify-center>
        <v-flex text-xs-center>
          <v-card flat tile color="primary" class="white--text">
            <v-card-text class="white--text pt-0">
              Diploma Calidad de Software, Diciembre 2018.
            </v-card-text>
          </v-card>
        </v-flex>
      </v-layout>
    </v-footer>

  </v-app>
</template>

<script>

export default {
  name: 'App',
  data () {
    return {
       drawer: null,
    }
  }
}
</script>
