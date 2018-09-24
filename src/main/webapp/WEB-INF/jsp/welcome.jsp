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

    <link rel="stylesheet" href="https://unpkg.com/vue-multiselect@2.1.0/dist/vue-multiselect.min.css">


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
                            @click="updateSeek($event)"
                            clearable

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
                            label="Enter Programming Language(Ex: C, JAVA, PHP, ruby etc.)"
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
                <%--<v-btn slot="activator" color="primary" dark class="mb-2">All Item</v-btn>--%>
                <div class="v-toolbar__content" style="height: 64px;">
                    <div class="v-toolbar__title"></div>
                    <hr class="mx-2 v-divider v-divider--inset v-divider--vertical theme--light">
                    <div class="spacer"></div>
                    <div class="v-dialog__container" style="display: inline-block;">
                        <div class="v-dialog__activator">
                            <button type="button" class="mb-2 v-btn theme--dark primary" style="position: relative;">
                                <div @click="getAllpna" class="v-btn__content">All Programming Language Not used</div>
                                <%--getAllProgrammingLanguageDataNotEnrolled--%>
                            </button>
                            <button type="button" class="mb-2 v-btn theme--dark primary" style="position: relative;">
                                <div @click="getAllData" class="v-btn__content">All Item</div>
                            </button>
                        </div>
                    </div>
                </div>
                <v-card>

                    <%--<div>--%>
                    <%--<label class="typo__label">Simple select / dropdown</label>--%>
                    <%--<multiselect v-model="value" :options="options" :multiple="false" :close-on-select="false" :clear-on-select="false" :hide-selected="true" :preserve-search="true" placeholder="Pick some" label="name" track-by="name" :preselect-first="true">--%>
                    <%--<template slot="tag" slot-scope="props"><span class="custom__tag"><span>{{ props.option.language }}</span><span class="custom__remove" @click="props.remove(props.option)">x</span></span></template>--%>
                    <%--</multiselect>--%>
                    <%--<pre class="language-json"><code>{{ value  }}</code></pre>--%>
                    <%--</div>--%>


                </v-card>


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
                                }}
                            </td>
                            <td>{{ props.item.language
                                }}
                            </td>
                        </template>

                        <v-alert slot="no-results" :value="true" color="error" icon="warning">
                            Your search for "{{ search }}" found no results.
                        </v-alert>
                    </v-data-table>
                </v-card>

                <%--start crud--%>
                <div>
                    <v-toolbar flat color="white">
                        <v-toolbar-title>Admin Panel(Interview)</v-toolbar-title>
                        <v-divider
                                class="mx-2"
                                inset
                                vertical
                        ></v-divider>
                        <v-spacer></v-spacer>
                        <v-dialog v-model="dialog" max-width="500px">
                            <v-btn slot="activator" color="primary" dark class="mb-2">New Item</v-btn>
                            <v-card>
                                <v-card-title>
                                    <span class="headline">{{ formTitle }}</span>
                                </v-card-title>

                                <v-card-text>
                                    <v-container grid-list-md>
                                        <v-layout wrap>
                                            <v-flex xs12 sm6 md4>
                                                <v-text-field v-model="editedItem.name"
                                                              label="Interview name"></v-text-field>
                                            </v-flex>
                                            <%--<v-flex xs12 sm6 md4>--%>
                                            <%--<v-text-field v-model="editedItem.calories" label="Calories"></v-text-field>--%>
                                            <%--</v-flex>--%>
                                            <%--<v-flex xs12 sm6 md4>--%>
                                            <%--<v-text-field v-model="editedItem.fat" label="Fat (g)"></v-text-field>--%>
                                            <%--</v-flex>--%>
                                            <%--<v-flex xs12 sm6 md4>--%>
                                            <%--<v-text-field v-model="editedItem.carbs" label="Carbs (g)"></v-text-field>--%>
                                            <%--</v-flex>--%>
                                            <%--<v-flex xs12 sm6 md4>--%>
                                            <%--<v-text-field v-model="editedItem.protein" label="Protein (g)"></v-text-field>--%>
                                            <%--</v-flex>--%>
                                        </v-layout>
                                    </v-container>
                                </v-card-text>

                                <v-card-actions>
                                    <v-spacer></v-spacer>
                                    <v-btn color="blue darken-1" flat @click.native="close">Cancel</v-btn>
                                    <v-btn color="blue darken-1" flat @click.native="save">Save</v-btn>
                                </v-card-actions>
                            </v-card>
                        </v-dialog>
                    </v-toolbar>
                    <v-data-table
                            :headers="cheaders"
                            :items="desserts"
                            hide-actions
                            class="elevation-1"
                    >
                        <template slot="items" slot-scope="props">
                            <td>{{ props.item.name }}</td>
                            <%--<td class="text-xs-right">{{ props.item.calories }}</td>--%>
                            <%--<td class="text-xs-right">{{ props.item.fat }}</td>--%>
                            <%--<td class="text-xs-right">{{ props.item.carbs }}</td>--%>
                            <%--<td class="text-xs-right">{{ props.item.protein }}</td>--%>
                            <td class="justify-center layout px-0">
                                <v-icon
                                        small
                                        class="mr-2"
                                        @click="editItem(props.item)"
                                >
                                    edit
                                </v-icon>
                                <v-icon
                                        small
                                        @click="deleteItem(props.item)"
                                >
                                    delete
                                </v-icon>
                            </td>
                        </template>
                        <template slot="no-data">
                            <v-btn color="primary" @click="initialize">Reset</v-btn>
                        </template>
                    </v-data-table>
                </div>

                <%--<v-card-text style="height: 100px;margin-top:60px; position: relative">--%>
                <%--<v-fab-transition>--%>
                <%--<v-btn--%>
                <%--v-show="!hidden"--%>
                <%--color="pink"--%>
                <%--dark--%>
                <%--absolute--%>
                <%--top--%>
                <%--right--%>
                <%--fab--%>
                <%-->--%>
                <%--<v-icon>add</v-icon>--%>
                <%--</v-btn>--%>
                <%--</v-fab-transition>--%>
                <%--</v-card-text>--%>
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
<script src="https://unpkg.com/vue-multiselect@2.1.0"></script>

<script>
    new Vue({
        el: '#app',
        components: {
            Multiselect: window.VueMultiselect.default
        },
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
            emails: [],
            programmingLanguages: [],
            languages: [],
            tableItems: [],


            value: [],
            options: [
                {name: 'Vue.js', language: 'JavaScript'},
                {name: 'Adonis', language: 'JavaScript'},
                {name: 'Rails', language: 'Ruby'},
                {name: 'Sinatra', language: 'Ruby'},
                {name: 'Laravel', language: 'PHP'},
                {name: 'Phoenix', language: 'Elixir'}
            ],


            //    added for crud operation
            dialog: false,
            cheaders: [
                {
                    text: 'Interview Name',
                    align: 'left',
                    sortable: true,
                    value: 'name'
                },
                // { text: 'Calories', value: 'calories' },
                // { text: 'Fat (g)', value: 'fat' },
                // { text: 'Carbs (g)', value: 'carbs' },
                // { text: 'Protein (g)', value: 'protein' },
                // { text: 'Actions', value: 'name', sortable: false }
            ],
            desserts: [],
            editedIndex: -1,
            editedItem: {
                name: '',
                calories: 0,
                fat: 0,
                carbs: 0,
                protein: 0
            },
            defaultItem: {
                name: '',
                calories: 0,
                fat: 0,
                carbs: 0,
                protein: 0
            },


        },
        watch: {
            searchEmail(val) {

                val && val !== this.select && this.querySelectionsSearchEmail(val);
                if (!val) {
                    this.selectEmail = null;
                    // alert('faka');
                    this.searchAll();
                }
            },
            searchProgrammingLanguage(val) {
                val && val !== this.select && this.querySelectionsSearchProgrammingLanguage(val);
                if (!val) {
                    this.selectProgrammingLanguage = null;
                    this.searchAll();
                }

            },
            searchLanguage(val) {
                val && val !== this.select && this.querySelectionsSearchLanguage(val);
                if (!val) {
                    this.selectLanguage = null;
                    this.searchAll();
                }
            },
            dialog(val) {
                val || this.close()
            },

        },
        methods: {
            querySelections(v) {
                this.loading = true;
                // Simulated ajax query
                alert('val:' + v);
                setTimeout(() => {
                    this.items = this.states.filter(e => {
                        return (e || '').toLowerCase().indexOf((v || '').toLowerCase()) > -1
                    });
                    this.loading = false
                }, 500)
            },
            querySelectionsSearchProgrammingLanguage(v) {
                this.plloading = true;
                // Simulated ajax query
                // alert('val:'+v);
                // alert('serch prog');


                axios.get('/getprogramminglanguagelist/' + v)
                    .then((response) => {
                        // handle success
                        // alert('come here');
                        console.log(response);
                        // this.desserts = response.data;
                        this.programmingLanguages = response.data;
                        // console.log("======start======'\n");
                        // console.log(this.programmingLanguages);
                        // console.log("==end==");
                        // document.getElementById('app').style.visibility = 'visible';
                        this.searchAll();


                    })
                    .catch(function (error) {
                        // handle error
                        console.log(error);
                    })
                    .then(function () {
                        // always executed

                        // alert('come');

                    });


                setTimeout(() => {
                    this.plitems = this.programmingLanguages.filter(e => {
                        return (e || '').toLowerCase().indexOf((v || '').toLowerCase()) > -1
                    });
                    this.plloading = false
                }, 500);

            },
            querySelectionsSearchLanguage(v) {
                this.lloading = true;
                // Simulated ajax query
                // alert('val:'+v);
                // alert('serch prog');


                axios.get('/getlanguagelist/' + v)
                    .then((response) => {
                        // handle success
                        // alert('come here');
                        console.log(response);
                        // this.desserts = response.data;
                        this.languages = response.data;
                        // console.log("======start======'\n");
                        // console.log(this.programmingLanguages);
                        // console.log("==end==");
                        // document.getElementById('app').style.visibility = 'visible';
                        this.searchAll();
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


                axios.get('/getemaillist/' + v)
                    .then((response) => {
                        // handle success
                        // alert('come here');
                        // console.log(response);
                        // this.desserts = response.data;
                        this.emails = response.data;
                        // console.log("======start======'\n");
                        // console.log(this.programmingLanguages);
                        // console.log("==end==");
                        // document.getElementById('app').style.visibility = 'visible';
                        this.searchAll();
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
            updateSeek(event) {
                // alert('called update');
            },
            nameWithLang({name, language}) {
                return `${name} — [${language}]`
            }, searchAll() {
                console.log('!!searchall called!!');
                var data = {
                    "email": this.selectEmail,
                    "code": this.selectLanguage,
                    "name": this.selectProgrammingLanguage
                };
                console.log(JSON.stringify(data));

                var url1 = "workordergenerate";
                axios.post('/searchalldata', {data})
                    .then(result => {
                        // alert('data from searchalldata!!');
                        console.log("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                        console.log(result.data);
                        console.log("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                        this.tableItems = result.data;


                    })
                    .catch(function (error) {
                    });
            },


            //    for crud -
            initialize() {
                this.desserts = [
                    {
                        name: 'Frozen Yogurt',
                        calories: 159,
                        fat: 6.0,
                        carbs: 24,
                        protein: 4.0
                    },
                    {
                        name: 'Ice cream sandwich',
                        calories: 237,
                        fat: 9.0,
                        carbs: 37,
                        protein: 4.3
                    },
                    {
                        name: 'Eclair',
                        calories: 262,
                        fat: 16.0,
                        carbs: 23,
                        protein: 6.0
                    },
                    {
                        name: 'Cupcake',
                        calories: 305,
                        fat: 3.7,
                        carbs: 67,
                        protein: 4.3
                    },
                    {
                        name: 'Gingerbread',
                        calories: 356,
                        fat: 16.0,
                        carbs: 49,
                        protein: 3.9
                    },
                    {
                        name: 'Jelly bean',
                        calories: 375,
                        fat: 0.0,
                        carbs: 94,
                        protein: 0.0
                    },
                    {
                        name: 'Lollipop',
                        calories: 392,
                        fat: 0.2,
                        carbs: 98,
                        protein: 0
                    },
                    {
                        name: 'Honeycomb',
                        calories: 408,
                        fat: 3.2,
                        carbs: 87,
                        protein: 6.5
                    },
                    {
                        name: 'Donut',
                        calories: 452,
                        fat: 25.0,
                        carbs: 51,
                        protein: 4.9
                    },
                    {
                        name: 'KitKat',
                        calories: 518,
                        fat: 26.0,
                        carbs: 65,
                        protein: 7
                    }
                ]
                // alert('before get interview');
                axios.get('/getinterview')
                    .then((response) => {
                        this.desserts = response.data;
                        console.log("======start interview data ======'\n");
                        console.log(this.desserts);
                        console.log("==end interview data==");
                        // document.getElementById('app').style.visibility = 'visible';
                        // this.searchAll();
                    })
                    .catch(function (error) {
                        // handle error
                        console.log(error);
                    })
                    .then(function () {
                        // always executed
                    });
                // alert('after get interview');

            },

            editItem(item) {
                this.editedIndex = this.desserts.indexOf(item);
                this.editedItem = Object.assign({}, item);

                // console.log('!!interview update called!!');
                // var data = {
                //     "id" : item.id,
                //     "name" : item.name,
                // };
                // console.log(JSON.stringify(data));
                //
                // axios.post('/updateinterview', { "id" : item.id,
                //     "name" : item.name,})
                //     .then(result => {
                //         this.initialize();
                //
                //     })
                //     .catch(function (error) {
                //     });


                this.dialog = true
            },

            deleteItem(item) {
                console.log('----------------- ITEM DELETE _-------------');
                // console.log(item.id + ' --> ' + item.name);
                // console.log('==============');

                const index = this.desserts.indexOf(item);
                if (confirm('Are you sure you want to delete this item?')) {
                    // this.desserts.splice(index, 1);

                    axios.get('/deleteinterview/' + item.id)
                        .then((response) => {
                            // handle success
                            // alert('come here');
                            // console.log(response);
                            // this.desserts = response.data;
                            // this.emails = response.data;
                            // console.log("======start======'\n");
                            // console.log(this.programmingLanguages);
                            // console.log("==end==");
                            // document.getElementById('app').style.visibility = 'visible';
                            this.initialize();
                            // this.searchAll();
                        })
                        .catch(function (error) {
                            // handle error
                            console.log(error);
                        })
                        .then(function () {
                            // always executed
                        });


                }
            },

            close() {
                this.dialog = false;
                setTimeout(() => {
                    this.editedItem = Object.assign({}, this.defaultItem)
                    this.editedIndex = -1
                }, 300)
            },

            save() {
                if (this.editedIndex > -1) {
                    //probably create item
                    // Object.assign(this.desserts[this.editedIndex], this.editedItem)
                    console.log('!! inter view add called!!');
                    // var data = {
                    //     "id" : this.editedIndex,
                    //     "name" : this.editedItem.name,
                    // };
                    // console.log(JSON.stringify(data));

                    axios.post('/updateinterview', {
                        "id": this.editedItem.id,
                        "name": this.editedItem.name,
                    })
                        .then(result => {
                            this.initialize();

                        })
                        .catch(function (error) {
                        });


                } else {
                    console.log('!! inter view add called!!');
                    var data = {
                        // "id" : item.id,
                        "name": this.editedItem,
                    };
                    console.log(JSON.stringify(data));

                    axios.post('/createinterview', {"name": this.editedItem.name})
                        .then(result => {
                            this.initialize();

                        })
                        .catch(function (error) {
                        });
                    this.desserts.push(this.editedItem)
                }
                this.close()
            },

            getAllData() {
                axios.get('/searchall')
                    .then((response) => {
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
            },
            getAllpna() {
                axios.get('/allpna')
                    .then((response) => {
                        // handle success
                        // alert('come here');
                        console.log(response);
                        // this.desserts = response.data;
                        this.tableItems = response.data;
                        // console.log("======start======'\n");
                        // console.log(this.desserts);
                        // console.log("==end==");
                        // document.getElementById('app').style.visibility = 'visible';
                    })
                    .catch(function (error) {
                        // handle error
                        console.log(error);
                    })
                    .then(function () {
                        // always executed
                    });
            },




        },
        updated: function () {
            this.$nextTick(function () {
                // Code that will run only after the
                // entire view has been re-rendered
                // alert('called sometimes, - udated');
                //
                // if(this.selectProgrammingLanguage == this.searchProgrammingLanguage && this.selectProgrammingLanguage!=null ||
                // this.selectEmail == this.searchEmail && this.selectEmail != null ||
                // this.selectLanguage == this.searchLanguage && this.selectLanguage !=null
                // ){
                //     console.log('^^^^^^^^ success all criteria ^^^^^^^^^^^^!');
                //     // alert('sucess all criteria!');
                //     axios.get('/searchpl/'+this.selectProgrammingLanguage)
                //         .then( (response) =>{
                //             // handle success
                //             // alert('come here');
                //             console.log(response);
                //             // this.desserts = response.data;
                //             this.tableItems = response.data;
                //             console.log("======start======'\n");
                //             console.log(this.desserts);
                //             console.log("==end==");
                //             // alert('table value updated!!!!!!!!!! ');
                //             // document.getElementById('app').style.visibility = 'visible';
                //         })
                //         .catch(function (error) {
                //             // handle error
                //             console.log(error);
                //         })
                //         .then(function () {
                //             // always executed
                //         });
                //
                // }

                // this.searchAll();

            })
        },
        computed: {
            formTitle() {
                return this.editedIndex === -1 ? 'New Item' : 'Edit Item'
            }
        },
        created() {
            this.initialize()
        },


        mounted: function () {
            // $('#app').css('visibility','visible');
            axios.get('/searchall')
                .then((response) => {
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
