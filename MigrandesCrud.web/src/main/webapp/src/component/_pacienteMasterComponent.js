define(['controller/selectionController', 'model/cacheModel', 'model/pacienteMasterModel', 'component/_CRUDComponent', 'controller/tabController', 'component/pacienteComponent',
 'component/actividadComponent', 'component/episodioComponent'],
 function(SelectionController, CacheModel, PacienteMasterModel, CRUDComponent, TabController, PacienteComponent,
 actividadComponent, episodioComponent) {
    App.Component._PacienteMasterComponent = App.Component.BasicComponent.extend({
        initialize: function() {
            var self = this;
            this.configuration = App.Utils.loadComponentConfiguration('pacienteMaster');
            App.Model.PacienteMasterModel.prototype.urlRoot = this.configuration.context;
            this.componentId = App.Utils.randomInteger();
            
            this.masterComponent = new PacienteComponent();
            this.masterComponent.initialize();
            
            this.childComponents = [];
			
			this.initializeChildComponents();
            
            Backbone.on(this.masterComponent.componentId + '-post-paciente-create', function(params) {
                self.renderChilds(params);
            });
            Backbone.on(this.masterComponent.componentId + '-post-paciente-edit', function(params) {
                self.renderChilds(params);
            });
            Backbone.on(this.masterComponent.componentId + '-pre-paciente-list', function() {
                self.hideChilds();
            });
            Backbone.on('paciente-master-model-error', function(error) {
                Backbone.trigger(uComponent.componentId + '-' + 'error', {event: 'paciente-master-save', view: self, message: error});
            });
            Backbone.on(this.masterComponent.componentId + '-instead-paciente-save', function(params) {
                self.model.set('pacienteEntity', params.model);
                if (params.model) {
                    self.model.set('id', params.model.id);
                } else {
                    self.model.unset('id');
                }

				App.Utils.fillCacheList(
					'actividad',
					self.model,
					self.actividadComponent.getDeletedRecords(),
					self.actividadComponent.getUpdatedRecords(),
					self.actividadComponent.getCreatedRecords()
				);

				App.Utils.fillCacheList(
					'episodio',
					self.model,
					self.episodioComponent.getDeletedRecords(),
					self.episodioComponent.getUpdatedRecords(),
					self.episodioComponent.getCreatedRecords()
				);

                self.model.save({}, {
                    success: function() {
                        Backbone.trigger(self.masterComponent.componentId + '-' + 'post-paciente-save', {view: self, model : self.model});
                    },
                    error: function(error) {
                        Backbone.trigger(self.componentId + '-' + 'error', {event: 'paciente-master-save', view: self, error: error});
                    }
                });
			    if (this.postInit) {
					this.postInit();
				}
            });
        },
        render: function(domElementId){
			if (domElementId) {
				var rootElementId = $("#"+domElementId);
				this.masterElement = this.componentId + "-master";
				this.tabsElement = this.componentId + "-tabs";

				rootElementId.append("<div id='" + this.masterElement + "'></div>");
				rootElementId.append("<div id='" + this.tabsElement + "'></div>");
			}
			this.masterComponent.render(this.masterElement);
		},
		initializeChildComponents: function () {
			this.tabModel = new App.Model.TabModel({tabs: [
                {label: "Actividad", name: "actividad", enable: true},
                {label: "Episodio", name: "episodio", enable: true}
			]});
			this.tabs = new TabController({model: this.tabModel});

			this.actividadComponent = new actividadComponent();
            this.actividadComponent.initialize({cache: {data: [], mode: "memory"},pagination: false});
			this.childComponents.push(this.actividadComponent);

			this.episodioComponent = new episodioComponent();
            this.episodioComponent.initialize({cache: {data: [], mode: "memory"},pagination: false});
			this.childComponents.push(this.episodioComponent);

            var self = this;
            
            this.configToolbar(this.actividadComponent,true);
            Backbone.on(self.actividadComponent.componentId + '-post-actividad-create', function(params) {
                params.view.currentModel.setCacheList(params.view.currentList);
            });
            
            this.configToolbar(this.episodioComponent,true);
            Backbone.on(self.episodioComponent.componentId + '-post-episodio-create', function(params) {
                params.view.currentModel.setCacheList(params.view.currentList);
            });
            
		},
        renderChilds: function(params) {
            var self = this;
            
            var options = {
                success: function() {
                	self.tabs.render(self.tabsElement);

					self.actividadComponent.clearCache();
					self.actividadComponent.setRecords(self.model.get('listactividad'));
					self.actividadComponent.render(self.tabs.getTabHtmlId('actividad'));

					self.episodioComponent.clearCache();
					self.episodioComponent.setRecords(self.model.get('listepisodio'));
					self.episodioComponent.render(self.tabs.getTabHtmlId('episodio'));

                    $('#'+self.tabsElement).show();
                },
                error: function() {
                    Backbone.trigger(self.componentId + '-' + 'error', {event: 'paciente-edit', view: self, id: id, data: data, error: error});
                }
            };
            if (params.id) {
                self.model = new App.Model.PacienteMasterModel({id: params.id});
                self.model.fetch(options);
            } else {
                self.model = new App.Model.PacienteMasterModel();
                options.success();
            }


        },
        showMaster: function (flag) {
			if (typeof (flag) === "boolean") {
				if (flag) {
					$("#"+this.masterElement).show();
				} else {
					$("#"+this.masterElement).hide();
				}
			}
		},
        hideChilds: function() {
            $("#"+this.tabsElement).hide();
        },
		configToolbar: function(component, composite) {
		    component.removeGlobalAction('refresh');
			component.removeGlobalAction('print');
			component.removeGlobalAction('search');
			if (!composite) {
				component.removeGlobalAction('create');
				component.removeGlobalAction('save');
				component.removeGlobalAction('cancel');
				component.addGlobalAction({
					name: 'add',
					icon: 'glyphicon-send',
					displayName: 'Add',
					show: true
				}, function () {
					Backbone.trigger(component.componentId + '-toolbar-add');
				});
			}
        },
        getChilds: function(name){
			for (var idx in this.childComponents) {
				if (this.childComponents[idx].name === name) {
					return this.childComponents[idx].getRecords();
				}
			}
		},
		setChilds: function(childName,childData){
			for (var idx in this.childComponents) {
				if (this.childComponents[idx].name === childName) {
					this.childComponents[idx].setRecords(childData);
				}
			}
		},
		renderMaster: function(domElementId){
			this.masterComponent.render(domElementId);
		},
		renderChild: function(childName, domElementId){
			for (var idx in this.childComponents) {
				if (this.childComponents[idx].name === childName) {
					this.childComponents[idx].render(domElementId);
				}
			}
		}
    });

    return App.Component._PacienteMasterComponent;
});