/**
 * output package name
 */
package com.kingdee.eas.fdc.finance.client;

import org.apache.log4j.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;
import javax.swing.BorderFactory;
import javax.swing.event.*;
import javax.swing.KeyStroke;

import com.kingdee.bos.ctrl.swing.*;
import com.kingdee.bos.ctrl.kdf.table.*;
import com.kingdee.bos.ctrl.kdf.data.event.*;
import com.kingdee.bos.dao.*;
import com.kingdee.bos.dao.query.*;
import com.kingdee.bos.metadata.*;
import com.kingdee.bos.metadata.entity.*;
import com.kingdee.bos.ui.face.*;
import com.kingdee.bos.ui.util.ResourceBundleHelper;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.enums.EnumUtils;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.ctrl.swing.event.*;
import com.kingdee.bos.ctrl.kdf.table.event.*;
import com.kingdee.bos.ctrl.extendcontrols.*;
import com.kingdee.bos.ctrl.kdf.util.render.*;
import com.kingdee.bos.ui.face.IItemAction;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.bos.ui.util.IUIActionPostman;
import com.kingdee.bos.appframework.client.servicebinding.ActionProxyFactory;
import com.kingdee.bos.appframework.uistatemanage.ActionStateConst;
import com.kingdee.bos.appframework.validator.ValidateHelper;
import com.kingdee.bos.appframework.uip.UINavigator;


/**
 * output class name
 */
public abstract class AbstractFDCCostCloseBaseRptUI extends com.kingdee.eas.framework.client.ListUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractFDCCostCloseBaseRptUI.class);
    protected com.kingdee.bos.ctrl.swing.KDContainer ctnCostClose;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contPeriod;
    protected com.kingdee.bos.ctrl.swing.KDComboBox comboCostCloseSort;
    protected com.kingdee.bos.ctrl.swing.KDSpinner spiMonth;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCompany;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contProject;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtProject;
    protected com.kingdee.bos.ctrl.swing.KDSpinner spiYear;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCostCloseSort;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel1;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel2;
    protected com.kingdee.bos.ctrl.swing.KDButton btnOK;
    protected ActionSearch actionSearch = null;
    /**
     * output class constructor
     */
    public AbstractFDCCostCloseBaseRptUI() throws Exception
    {
        super();
        this.defaultObjectName = "mainQuery";
        jbInit();
        
        initUIP();
    }

    /**
     * output jbInit method
     */
    private void jbInit() throws Exception
    {
        this.resHelper = new ResourceBundleHelper(AbstractFDCCostCloseBaseRptUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        mainQueryPK = new MetaDataPK("com.kingdee.eas.base.message", "MsgQuery");
        //actionSearch
        this.actionSearch = new ActionSearch(this);
        getActionManager().registerAction("actionSearch", actionSearch);
         this.actionSearch.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        this.ctnCostClose = new com.kingdee.bos.ctrl.swing.KDContainer();
        this.contPeriod = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.comboCostCloseSort = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.spiMonth = new com.kingdee.bos.ctrl.swing.KDSpinner();
        this.contCompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.contProject = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtProject = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.spiYear = new com.kingdee.bos.ctrl.swing.KDSpinner();
        this.contCostCloseSort = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabel1 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kDLabel2 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.btnOK = new com.kingdee.bos.ctrl.swing.KDButton();
        this.ctnCostClose.setName("ctnCostClose");
        this.contPeriod.setName("contPeriod");
        this.comboCostCloseSort.setName("comboCostCloseSort");
        this.spiMonth.setName("spiMonth");
        this.contCompany.setName("contCompany");
        this.prmtCompany.setName("prmtCompany");
        this.contProject.setName("contProject");
        this.prmtProject.setName("prmtProject");
        this.spiYear.setName("spiYear");
        this.contCostCloseSort.setName("contCostCloseSort");
        this.kDLabel1.setName("kDLabel1");
        this.kDLabel2.setName("kDLabel2");
        this.btnOK.setName("btnOK");
        // CoreUI
		String tblMainStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol12\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"company\" t:width=\"100\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"true\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"project\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"item\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"standard\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"itemCount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"thisCount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"save\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"submit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"audit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"noSplit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"partSplit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"allSplit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"project.id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"19\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{company}</t:Cell><t:Cell>$Resource{project}</t:Cell><t:Cell>$Resource{item}</t:Cell><t:Cell>$Resource{standard}</t:Cell><t:Cell>$Resource{itemCount}</t:Cell><t:Cell>$Resource{thisCount}</t:Cell><t:Cell>$Resource{save}</t:Cell><t:Cell>$Resource{submit}</t:Cell><t:Cell>$Resource{audit}</t:Cell><t:Cell>$Resource{noSplit}</t:Cell><t:Cell>$Resource{partSplit}</t:Cell><t:Cell>$Resource{allSplit}</t:Cell><t:Cell>$Resource{project.id}</t:Cell></t:Row><t:Row t:name=\"header2\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{company_Row2}</t:Cell><t:Cell>$Resource{project_Row2}</t:Cell><t:Cell>$Resource{item_Row2}</t:Cell><t:Cell>$Resource{standard_Row2}</t:Cell><t:Cell>$Resource{itemCount_Row2}</t:Cell><t:Cell>$Resource{thisCount_Row2}</t:Cell><t:Cell>$Resource{save_Row2}</t:Cell><t:Cell>$Resource{submit_Row2}</t:Cell><t:Cell>$Resource{audit_Row2}</t:Cell><t:Cell>$Resource{noSplit_Row2}</t:Cell><t:Cell>$Resource{partSplit_Row2}</t:Cell><t:Cell>$Resource{allSplit_Row2}</t:Cell><t:Cell>$Resource{project.id_Row2}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot> ";
		
        this.tblMain.setFormatXml(resHelper.translateString("tblMain",tblMainStrXML));
                this.tblMain.putBindContents("mainQuery",new String[] {"","","","","","","","","","","","",""});


        // ctnCostClose		
        this.ctnCostClose.setTitle(resHelper.getString("ctnCostClose.title"));
        // contPeriod		
        this.contPeriod.setBoundLabelText(resHelper.getString("contPeriod.boundLabelText"));		
        this.contPeriod.setBoundLabelLength(60);		
        this.contPeriod.setBoundLabelUnderline(true);
        // comboCostCloseSort		
        this.comboCostCloseSort.addItems(EnumUtils.getEnumList("com.kingdee.eas.fdc.finance.FDCCostCloseSortEnum").toArray());
        this.comboCostCloseSort.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent e) {
                try {
                    comboCostCloseSort_itemStateChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // spiMonth
        this.spiMonth.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent e) {
                try {
                    spiMonth_stateChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // contCompany		
        this.contCompany.setBoundLabelText(resHelper.getString("contCompany.boundLabelText"));		
        this.contCompany.setBoundLabelUnderline(true);		
        this.contCompany.setBoundLabelLength(100);
        // prmtCompany		
        this.prmtCompany.setQueryInfo("com.kingdee.eas.basedata.org.app.F7BizUnitCompanyOrgUnitQuery");		
        this.prmtCompany.setDisplayFormat("$name$");		
        this.prmtCompany.setEditFormat("$number$");		
        this.prmtCompany.setCommitFormat("$number$");
        this.prmtCompany.addSelectorListener(new com.kingdee.bos.ctrl.swing.event.SelectorListener() {
            public void willShow(com.kingdee.bos.ctrl.swing.event.SelectorEvent e) {
                try {
                    prmtCompany_willShow(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        this.prmtCompany.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtCompany_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // contProject		
        this.contProject.setBoundLabelText(resHelper.getString("contProject.boundLabelText"));		
        this.contProject.setBoundLabelLength(100);		
        this.contProject.setBoundLabelUnderline(true);
        // prmtProject		
        this.prmtProject.setQueryInfo("com.kingdee.eas.fdc.basedata.app.F7ProjectQuery");		
        this.prmtProject.setCommitFormat("$number$");		
        this.prmtProject.setEditFormat("$number$");		
        this.prmtProject.setDisplayFormat("$name$");
        this.prmtProject.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtProject_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        this.prmtProject.addSelectorListener(new com.kingdee.bos.ctrl.swing.event.SelectorListener() {
            public void willShow(com.kingdee.bos.ctrl.swing.event.SelectorEvent e) {
                try {
                    prmtProject_willShow(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // spiYear
        this.spiYear.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent e) {
                try {
                    spiYear_stateChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // contCostCloseSort		
        this.contCostCloseSort.setBoundLabelText(resHelper.getString("contCostCloseSort.boundLabelText"));		
        this.contCostCloseSort.setBoundLabelLength(60);		
        this.contCostCloseSort.setBoundLabelUnderline(true);
        // kDLabel1		
        this.kDLabel1.setText(resHelper.getString("kDLabel1.text"));
        // kDLabel2		
        this.kDLabel2.setText(resHelper.getString("kDLabel2.text"));
        // btnOK
        this.btnOK.setAction((IItemAction)ActionProxyFactory.getProxy(actionSearch, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnOK.setText(resHelper.getString("btnOK.text"));
		//Register control's property binding
		registerBindings();
		registerUIState();


    }

	public com.kingdee.bos.ctrl.swing.KDToolBar[] getUIMultiToolBar(){
		java.util.List list = new java.util.ArrayList();
		com.kingdee.bos.ctrl.swing.KDToolBar[] bars = super.getUIMultiToolBar();
		if (bars != null) {
			list.addAll(java.util.Arrays.asList(bars));
		}
		return (com.kingdee.bos.ctrl.swing.KDToolBar[])list.toArray(new com.kingdee.bos.ctrl.swing.KDToolBar[list.size()]);
	}




    /**
     * output initUIContentLayout method
     */
    public void initUIContentLayout()
    {
        this.setBounds(new Rectangle(10, 10, 1013, 629));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(10, 10, 1013, 629));
        ctnCostClose.setBounds(new Rectangle(10, 40, 989, 577));
        this.add(ctnCostClose, new KDLayout.Constraints(10, 40, 989, 577, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contPeriod.setBounds(new Rectangle(232, 11, 113, 19));
        this.add(contPeriod, new KDLayout.Constraints(232, 11, 113, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        spiMonth.setBounds(new Rectangle(369, 11, 42, 19));
        this.add(spiMonth, new KDLayout.Constraints(369, 11, 42, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCompany.setBounds(new Rectangle(446, 11, 200, 19));
        this.add(contCompany, new KDLayout.Constraints(446, 11, 200, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contProject.setBounds(new Rectangle(670, 11, 200, 19));
        this.add(contProject, new KDLayout.Constraints(670, 11, 200, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCostCloseSort.setBounds(new Rectangle(10, 11, 200, 19));
        this.add(contCostCloseSort, new KDLayout.Constraints(10, 11, 200, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabel1.setBounds(new Rectangle(351, 11, 18, 19));
        this.add(kDLabel1, new KDLayout.Constraints(351, 11, 18, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabel2.setBounds(new Rectangle(416, 11, 21, 19));
        this.add(kDLabel2, new KDLayout.Constraints(416, 11, 21, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnOK.setBounds(new Rectangle(900, 11, 73, 21));
        this.add(btnOK, new KDLayout.Constraints(900, 11, 73, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //ctnCostClose
ctnCostClose.getContentPane().setLayout(new BorderLayout(0, 0));        ctnCostClose.getContentPane().add(tblMain, BorderLayout.CENTER);
        //contPeriod
        contPeriod.setBoundEditor(spiYear);
        //contCompany
        contCompany.setBoundEditor(prmtCompany);
        //contProject
        contProject.setBoundEditor(prmtProject);
        //contCostCloseSort
        contCostCloseSort.setBoundEditor(comboCostCloseSort);

    }


    /**
     * output initUIMenuBarLayout method
     */
    public void initUIMenuBarLayout()
    {
        this.menuBar.add(menuFile);
        this.menuBar.add(menuEdit);
        this.menuBar.add(MenuService);
        this.menuBar.add(menuView);
        this.menuBar.add(menuBiz);
        this.menuBar.add(menuTool);
        this.menuBar.add(menuTools);
        this.menuBar.add(menuHelp);
        //menuFile
        menuFile.add(menuItemAddNew);
        menuFile.add(menuItemImportData);
        menuFile.add(menuItemExportData);
        menuFile.add(separatorFile1);
        menuFile.add(MenuItemAttachment);
        menuFile.add(kDSeparator1);
        menuFile.add(menuItemPageSetup);
        menuFile.add(menuItemPrint);
        menuFile.add(menuItemPrintPreview);
        menuFile.add(kDSeparator2);
        menuFile.add(menuItemExitCurrent);
        //menuEdit
        menuEdit.add(menuItemEdit);
        menuEdit.add(menuItemRemove);
        //MenuService
        MenuService.add(MenuItemKnowStore);
        MenuService.add(MenuItemAnwser);
        MenuService.add(SepratorService);
        MenuService.add(MenuItemRemoteAssist);
        //menuView
        menuView.add(menuItemView);
        menuView.add(menuItemLocate);
        menuView.add(separatorView1);
        menuView.add(menuItemQuery);
        menuView.add(menuItemQueryScheme);
        menuView.add(menuItemRefresh);
        //menuBiz
        menuBiz.add(menuItemCancelCancel);
        menuBiz.add(menuItemCancel);
        //menuTool
        menuTool.add(menuItemSendMessage);
        menuTool.add(menuItemCalculator);
        //menuTools
        menuTools.add(menuMail);
        menuTools.add(menuItemStartWorkFlow);
        menuTools.add(menuItemPublishReport);
        //menuMail
        menuMail.add(menuItemToHTML);
        menuMail.add(menuItemCopyScreen);
        menuMail.add(menuItemToExcel);
        //menuHelp
        menuHelp.add(menuItemHelp);
        menuHelp.add(kDSeparator12);
        menuHelp.add(menuItemRegPro);
        menuHelp.add(menuItemPersonalSite);
        menuHelp.add(helpseparatorDiv);
        menuHelp.add(menuitemProductval);
        menuHelp.add(kDSeparatorProduct);
        menuHelp.add(menuItemAbout);

    }

    /**
     * output initUIToolBarLayout method
     */
    public void initUIToolBarLayout()
    {
        this.toolBar.add(btnAddNew);
        this.toolBar.add(btnView);
        this.toolBar.add(btnEdit);
        this.toolBar.add(btnRemove);
        this.toolBar.add(btnRefresh);
        this.toolBar.add(btnQuery);
        this.toolBar.add(btnLocate);
        this.toolBar.add(btnAttachment);
        this.toolBar.add(separatorFW1);
        this.toolBar.add(btnPageSetup);
        this.toolBar.add(btnPrint);
        this.toolBar.add(btnPrintPreview);
        this.toolBar.add(separatorFW2);
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnCancel);
        this.toolBar.add(btnQueryScheme);


    }

	//Regiester control's property binding.
	private void registerBindings(){		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.fdc.finance.app.FDCCostCloseBaseRptUIHandler";
	}
	public IUIActionPostman prepareInit() {
		IUIActionPostman clientHanlder = super.prepareInit();
		if (clientHanlder != null) {
			RequestContext request = new RequestContext();
    		request.setClassName(getUIHandlerClassName());
			clientHanlder.setRequestContext(request);
		}
		return clientHanlder;
    }
	
	public boolean isPrepareInit() {
    	return false;
    }
    protected void initUIP() {
        super.initUIP();
    }



	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
    }

    /**
     * output loadFields method
     */
    public void loadFields()
    {
        dataBinder.loadFields();
    }
    /**
     * output storeFields method
     */
    public void storeFields()
    {
		dataBinder.storeFields();
    }

	/**
	 * ????????��??
	 */
	protected void registerValidator() {
    	getValidateHelper().setCustomValidator( getValidator() );		
	}



    /**
     * output setOprtState method
     */
    public void setOprtState(String oprtType)
    {
        super.setOprtState(oprtType);
    }

    /**
     * output comboCostCloseSort_itemStateChanged method
     */
    protected void comboCostCloseSort_itemStateChanged(java.awt.event.ItemEvent e) throws Exception
    {
    }

    /**
     * output spiMonth_stateChanged method
     */
    protected void spiMonth_stateChanged(javax.swing.event.ChangeEvent e) throws Exception
    {
    }

    /**
     * output prmtCompany_willShow method
     */
    protected void prmtCompany_willShow(com.kingdee.bos.ctrl.swing.event.SelectorEvent e) throws Exception
    {
    }

    /**
     * output prmtCompany_dataChanged method
     */
    protected void prmtCompany_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output prmtProject_dataChanged method
     */
    protected void prmtProject_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output prmtProject_willShow method
     */
    protected void prmtProject_willShow(com.kingdee.bos.ctrl.swing.event.SelectorEvent e) throws Exception
    {
    }

    /**
     * output spiYear_stateChanged method
     */
    protected void spiYear_stateChanged(javax.swing.event.ChangeEvent e) throws Exception
    {
    }

    /**
     * output getSelectors method
     */
    public SelectorItemCollection getSelectors()
    {
        SelectorItemCollection sic = new SelectorItemCollection();
        return sic;
    }        
    	

    /**
     * output actionSearch_actionPerformed method
     */
    public void actionSearch_actionPerformed(ActionEvent e) throws Exception
    {
    }
	public RequestContext prepareActionSearch(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionSearch() {
    	return false;
    }

    /**
     * output ActionSearch class
     */     
    protected class ActionSearch extends ItemAction {     
    
        public ActionSearch()
        {
            this(null);
        }

        public ActionSearch(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionSearch.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionSearch.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionSearch.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractFDCCostCloseBaseRptUI.this, "ActionSearch", "actionSearch_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.fdc.finance.client", "FDCCostCloseBaseRptUI");
    }




}