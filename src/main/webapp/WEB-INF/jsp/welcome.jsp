<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->


<head>
    <meta charset="utf-8"/>
    <title>Simple Search Application</title>
    <link href='https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Material+Icons' rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/vuetify/dist/vuetify.min.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, minimal-ui">
</head>
<body>
<div id="app" style="visibility: hidden">
    <v-app id="inspire">
        <v-navigation-drawer
                fixed
                v-model="drawer"
                app
        >
            <v-list dense>
                <v-list-tile @click="">
                    <v-list-tile-action>
                        <v-icon>home</v-icon>
                    </v-list-tile-action>
                    <v-list-tile-content>
                        <v-list-tile-title>Home</v-list-tile-title>
                    </v-list-tile-content>
                </v-list-tile>
                <%--<v-list-tile @click="">--%>
                    <%--<v-list-tile-action>--%>
                        <%--<v-icon>contact_mail</v-icon>--%>
                    <%--</v-list-tile-action>--%>
                    <%--&lt;%&ndash;<v-list-tile-content>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<v-list-tile-title>Admin</v-list-tile-title>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;</v-list-tile-content>&ndash;%&gt;--%>
                <%--</v-list-tile>--%>
            </v-list>
        </v-navigation-drawer>
        <v-toolbar color="indigo" dark fixed app>
            <v-toolbar-side-icon @click.stop="drawer = !drawer"></v-toolbar-side-icon>
            <v-toolbar-title>Simple Search Application</v-toolbar-title>
        </v-toolbar>
        <v-content>
            <%--<h1>App -</h1>--%>
            <v-app id="inspire">
                <v-toolbar
                        dark
                        color="teal"
                >
                    <%--<v-toolbar-title>Email selection</v-toolbar-title>--%>
                    <v-autocomplete
                            :loading="eloading"
                            :items="emailitems"
                            :search-input.sync="searchEmail"
                            v-model="selectEmail"
                            cache-items
                            class="mx-3"
                            flat
                            hide-no-data
                            hide-details
                            label="Enter Email Address"
                            solo-inverted
                    ></v-autocomplete>
                    <v-btn icon>
                        <v-icon>more_vert</v-icon>
                    </v-btn>
                </v-toolbar>
                <v-toolbar
                        dark
                        color="teal"
                >
                    <%--<v-toolbar-title>Programming Languages selection</v-toolbar-title>--%>
                    <v-autocomplete
                            :loading="plloading"
                            :items="plitems"
                            :search-input.sync="searchProgrammingLanguage"
                            v-model="selectProgrammingLanguage"
                            cache-items
                            class="mx-3"
                            flat
                            hide-no-data
                            hide-details
                            label="Enter Programming Language(Ex: ruby, javascript, php etc.)"
                            solo-inverted
                    ></v-autocomplete>
                    <v-btn icon>
                        <v-icon>more_vert</v-icon>
                    </v-btn>
                </v-toolbar>
                <v-toolbar
                        dark
                        color="teal"
                >
                    <%--<v-toolbar-title>Languages selection</v-toolbar-title>--%>
                    <v-autocomplete
                            :loading="lloading"
                            :items="litems"
                            :search-input.sync="searchLanguage"
                            v-model="selectLanguage"
                            cache-items
                            class="mx-3"
                            flat
                            hide-no-data
                            hide-details
                            label="Enter Language(Ex: jp, en, bd etc.)"
                            solo-inverted
                    ></v-autocomplete>
                    <v-btn icon>
                        <v-icon>more_vert</v-icon>
                    </v-btn>
                </v-toolbar>
                <v-card>
                    <v-card-title>
                        <%--Nutrition--%>
                        <%--<v-spacer></v-spacer>--%>
                        <%--<v-text-field--%>
                                <%--v-model="search"--%>
                                <%--append-icon="search"--%>
                                <%--label="Search"--%>
                                <%--single-line--%>
                                <%--hide-details--%>
                        <%--></v-text-field>--%>



                            <%--<template slot="items" slot-scope="props">--%>
                                <%--<td>{{ props.item.email }}</td>--%>
                                <%--<td>{{ props.item.programmingLanguage--%>
                                    <%--}}</td>--%>
                                <%--<td>{{ props.item.language--%>
                                    <%--}}</td>--%>
                            <%--</template>--%>


                    </v-card-title>
                    <v-data-table
                            :headers="headers"
                            :items="tableItems"
                            :search="search"
                    >
                        <%--<template slot="items" slot-scope="props">--%>
                            <%--<td>{{ props.item.name }}</td>--%>
                            <%--<td>{{ props.item.calories }}</td>--%>
                            <%--<td>{{ props.item.fat }}</td>--%>
                        <%--</template>--%>

                        <template slot="items" slot-scope="props">
                        <td>{{ props.item.email }}</td>
                        <td>{{ props.item.programmingLanguage
                        }}</td>
                        <td>{{ props.item.language
                        }}</td>
                        </template>

                        <v-alert slot="no-results" :value="true" color="error" icon="warning">
                            Your search for "{{ search }}" found no results.
                        </v-alert>
                    </v-data-table>
                </v-card>
            </v-app>
        </v-content>
        <v-footer color="indigo" app inset>
            <span class="white--text">&copy; Developed By, <a style="color:#c7f972;"
                                                              href="https://www.linkedin.com/in/forhadmethun/">Forhad Hossain Methun</a> </span>
        </v-footer>
    </v-app>
</div>

<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vuetify/dist/vuetify.js"></script>
<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>--%>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script>
    new Vue({
        el: '#app',
        data: {
            drawer: null,
            search: '',
            headers: [
                {text: 'email', value: 'calories'},
                {text: 'programming_languages', value: 'fat'},
                {text: 'languages', value: 'carbs'},
            ],
            desserts: [
                {
                    value: false,
                    name: 'Frozen Yogurt',
                    calories: 159,
                    fat: 6.0,
                    carbs: 24,
                    protein: 4.0,
                    iron: '1%'
                },
                {
                    value: false,
                    name: 'Ice cream sandwich',
                    calories: 237,
                    fat: 9.0,
                    carbs: 37,
                    protein: 4.3,
                    iron: '1%'
                },
                {
                    value: false,
                    name: 'Eclair',
                    calories: 262,
                    fat: 16.0,
                    carbs: 23,
                    protein: 6.0,
                    iron: '7%'
                },
                {
                    value: false,
                    name: 'Cupcake',
                    calories: 305,
                    fat: 3.7,
                    carbs: 67,
                    protein: 4.3,
                    iron: '8%'
                },
                {
                    value: false,
                    name: 'Gingerbread',
                    calories: 356,
                    fat: 16.0,
                    carbs: 49,
                    protein: 3.9,
                    iron: '16%'
                },
                {
                    value: false,
                    name: 'Jelly bean',
                    calories: 375,
                    fat: 0.0,
                    carbs: 94,
                    protein: 0.0,
                    iron: '0%'
                },
                {
                    value: false,
                    name: 'Lollipop',
                    calories: 392,
                    fat: 0.2,
                    carbs: 98,
                    protein: 0,
                    iron: '2%'
                },
                {
                    value: false,
                    name: 'Honeycomb',
                    calories: 408,
                    fat: 3.2,
                    carbs: 87,
                    protein: 6.5,
                    iron: '45%'
                },
                {
                    value: false,
                    name: 'Donut',
                    calories: 452,
                    fat: 25.0,
                    carbs: 51,
                    protein: 4.9,
                    iron: '22%'
                },
                {
                    value: false,
                    name: 'KitKat',
                    calories: 518,
                    fat: 26.0,
                    carbs: 65,
                    protein: 7,
                    iron: '6%'
                }
            ],
            loading: false,
            eloading: false,
            lloading: false,
            plloading: false,
            items: [],
            emailitems: [],
            plitems: [],
            litems: [],
            searchEmail: null,
            searchProgrammingLanguage: null,
            searchLanguage: null,
            select: null,
            selectEmail: null,
            selectProgrammingLanguage: null,
            selectLanguage: null,
            states: [
                'Alabama',
                'Alaska',
                'American Samoa',
                'Arizona',
                'Arkansas',
                'California',
                'Colorado',
                'Connecticut',
                'Delaware',
                'District of Columbia',
                'Federated States of Micronesia',
                'Florida',
                'Georgia',
                'Guam',
                'Hawaii',
                'Idaho',
                'Illinois',
                'Indiana',
                'Iowa',
                'Kansas',
                'Kentucky',
                'Louisiana',
                'Maine',
                'Marshall Islands',
                'Maryland',
                'Massachusetts',
                'Michigan',
                'Minnesota',
                'Mississippi',
                'Missouri',
                'Montana',
                'Nebraska',
                'Nevada',
                'New Hampshire',
                'New Jersey',
                'New Mexico',
                'New York',
                'North Carolina',
                'North Dakota',
                'Northern Mariana Islands',
                'Ohio',
                'Oklahoma',
                'Oregon',
                'Palau',
                'Pennsylvania',
                'Puerto Rico',
                'Rhode Island',
                'South Carolina',
                'South Dakota',
                'Tennessee',
                'Texas',
                'Utah',
                'Vermont',
                'Virgin Island',
                'Virginia',
                'Washington',
                'West Virginia',
                'Wisconsin',
                'Wyoming'
            ],
            emails:[],
            programmingLanguages:[],
            languages:[],
            tableItems:[],

        },
        watch: {
            searchEmail (val) {
                val && val !== this.select && this.querySelectionsSearchEmail(val)
            },
            searchProgrammingLanguage (val) {
                val && val !== this.select && this.querySelectionsSearchProgrammingLanguage(val)
            } ,
            searchLanguage (val) {
                val && val !== this.select && this.querySelectionsSearchLanguage(val)
            }
        },
        methods: {
            querySelections (v) {
                this.loading = true;
                // Simulated ajax query
                 alert('val:'+v);
                setTimeout(() => {
                    this.items = this.states.filter(e => {
                    return (e || '').toLowerCase().indexOf((v || '').toLowerCase()) > -1
            });
                this.loading = false
            }, 500)
            },
            querySelectionsSearchProgrammingLanguage (v) {
                this.plloading = true;
                // Simulated ajax query
                // alert('val:'+v);
                // alert('serch prog');


                axios.get('/getprogramminglanguagelist/'+v)
                    .then( (response) =>{
                        // handle success
                        // alert('come here');
                        console.log(response);
                        // this.desserts = response.data;
                        this.programmingLanguages = response.data;
                        console.log("======start======'\n");
                        console.log(this.programmingLanguages);
                        console.log("==end==");
                        // document.getElementById('app').style.visibility = 'visible';
                    })
                    .catch(function (error) {
                        // handle error
                        console.log(error);
                    })
                    .then(function () {
                        // always executed
                    });


                setTimeout(() => {
                    this.plitems= this.programmingLanguages.filter(e => {
                        return (e || '').toLowerCase().indexOf((v || '').toLowerCase()) > -1
                    });
                    this.plloading = false
                }, 500)
            },
            querySelectionsSearchLanguage (v) {
                this.lloading = true;
                // Simulated ajax query
                // alert('val:'+v);
                // alert('serch prog');


                axios.get('/getlanguagelist/'+v)
                    .then( (response) =>{
                        // handle success
                        // alert('come here');
                        console.log(response);
                        // this.desserts = response.data;
                        this.languages = response.data;
                        console.log("======start======'\n");
                        console.log(this.programmingLanguages);
                        console.log("==end==");
                        // document.getElementById('app').style.visibility = 'visible';
                    })
                    .catch(function (error) {
                        // handle error
                        console.log(error);
                    })
                    .then(function () {
                        // always executed
                    });


                setTimeout(() => {
                    this.litems = this.languages.filter(e => {
                        return (e || '').toLowerCase().indexOf((v || '').toLowerCase()) > -1
                    });
                    this.lloading = false
                }, 500)
            },
            querySelectionsSearchEmail(v) {
                this.eloading = true;
                // Simulated ajax query
                // alert('val:'+v);
                // alert('serch prog');


                axios.get('/getemaillist/'+v)
                    .then( (response) =>{
                        // handle success
                        // alert('come here');
                        console.log(response);
                        // this.desserts = response.data;
                        this.emails = response.data;
                        console.log("======start======'\n");
                        console.log(this.programmingLanguages);
                        console.log("==end==");
                        // document.getElementById('app').style.visibility = 'visible';
                    })
                    .catch(function (error) {
                        // handle error
                        console.log(error);
                    })
                    .then(function () {
                        // always executed
                    });


                setTimeout(() => {
                    this.emailitems = this.emails.filter(e => {
                        return (e || '').toLowerCase().indexOf((v || '').toLowerCase()) > -1
                    });
                    this.eloading = false
                }, 500)
            },
        },


        mounted: function () {
            // $('#app').css('visibility','visible');
            axios.get('/searchall')
                .then( (response) =>{
                    // handle success
                    // alert('come here');
                    console.log(response);
                    // this.desserts = response.data;
                    this.tableItems = response.data;
                    console.log("======start======'\n");
                    console.log(this.desserts);
                    console.log("==end==");
                    document.getElementById('app').style.visibility = 'visible';
                })
                .catch(function (error) {
                    // handle error
                    console.log(error);
                })
                .then(function () {
                    // always executed
                });



        }
    })
</script>


</body>

</html>
