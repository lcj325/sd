/**
 * output package name
 */
package com.kingdee.eas.fdc.sellhouse.client;

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
public abstract class AbstractCommerceChanceImportUI extends com.kingdee.eas.framework.client.ListUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractCommerceChanceImportUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contModifyCount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contSysType;
    protected com.kingdee.bos.ctrl.swing.KDComboBox comboSysType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contFilePath;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contExcelTotalNum;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contInvaluidCount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAddNewCount;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtFilePath;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtModifyCount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtAddNewCount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtInvaluidCount;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtSellProject;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contSellProject;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtExcelCount;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnExcelImport;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnExcelSave;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemExcelImport;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemExcelSave;
    protected ActionExcelImport actionExcelImport = null;
    protected ActionExcelSave actionExcelSave = null;
    /**
     * output class constructor
     */
    public AbstractCommerceChanceImportUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractCommerceChanceImportUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        mainQueryPK = new MetaDataPK("com.kingdee.eas.base.message", "MsgQuery");
        //actionExcelImport
        this.actionExcelImport = new ActionExcelImport(this);
        getActionManager().registerAction("actionExcelImport", actionExcelImport);
         this.actionExcelImport.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionExcelSave
        this.actionExcelSave = new ActionExcelSave(this);
        getActionManager().registerAction("actionExcelSave", actionExcelSave);
         this.actionExcelSave.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        this.contModifyCount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contSysType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.comboSysType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.contFilePath = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contExcelTotalNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contInvaluidCount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAddNewCount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtFilePath = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtModifyCount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtAddNewCount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtInvaluidCount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtSellProject = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.contSellProject = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtExcelCount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.btnExcelImport = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnExcelSave = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.menuItemExcelImport = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemExcelSave = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.contModifyCount.setName("contModifyCount");
        this.contSysType.setName("contSysType");
        this.comboSysType.setName("comboSysType");
        this.contFilePath.setName("contFilePath");
        this.contExcelTotalNum.setName("contExcelTotalNum");
        this.contInvaluidCount.setName("contInvaluidCount");
        this.contAddNewCount.setName("contAddNewCount");
        this.txtFilePath.setName("txtFilePath");
        this.txtModifyCount.setName("txtModifyCount");
        this.txtAddNewCount.setName("txtAddNewCount");
        this.txtInvaluidCount.setName("txtInvaluidCount");
        this.prmtSellProject.setName("prmtSellProject");
        this.contSellProject.setName("contSellProject");
        this.txtExcelCount.setName("txtExcelCount");
        this.btnExcelImport.setName("btnExcelImport");
        this.btnExcelSave.setName("btnExcelSave");
        this.menuItemExcelImport.setName("menuItemExcelImport");
        this.menuItemExcelSave.setName("menuItemExcelSave");
        // CoreUI
		String tblMainStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"100\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"true\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"importStatus\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"1\" /><t:Column t:key=\"saleMan\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"2\" /><t:Column t:key=\"fdcCustomer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"3\" /><t:Column t:key=\"number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"4\" /><t:Column t:key=\"name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"5\" /><t:Column t:key=\"phoneNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"6\" /><t:Column t:key=\"commerceLevel\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"7\" /><t:Column t:key=\"commerceDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"8\" /><t:Column t:key=\"intentBuildingPro\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"9\" /><t:Column t:key=\"intentProductType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"10\" /><t:Column t:key=\"productDeatil\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"11\" /><t:Column t:key=\"intentDirection\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"12\" /><t:Column t:key=\"intentArea\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"13\" /><t:Column t:key=\"intentSight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"14\" /><t:Column t:key=\"roomForm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"15\" /><t:Column t:key=\"intentRoomType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"16\" /><t:Column t:key=\"hopedUnitPrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"17\" /><t:Column t:key=\"hopedTotalPrices\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"18\" /><t:Column t:key=\"hopedFloor\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"19\" /><t:Column t:key=\"buyHouseReason\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"20\" /><t:Column t:key=\"hopedPitch\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"21\" /><t:Column t:key=\"commerceIntention\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"22\" /><t:Column t:key=\"intendingDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"23\" /><t:Column t:key=\"intendingMoney\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"24\" /><t:Column t:key=\"firstPayProportion\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"25\" /><t:Column t:key=\"description\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"26\" /><t:Column t:key=\"bargainOnCondition\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"27\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"19\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{importStatus}</t:Cell><t:Cell>$Resource{saleMan}</t:Cell><t:Cell>$Resource{fdcCustomer}</t:Cell><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{name}</t:Cell><t:Cell>$Resource{phoneNumber}</t:Cell><t:Cell>$Resource{commerceLevel}</t:Cell><t:Cell>$Resource{commerceDate}</t:Cell><t:Cell>$Resource{intentBuildingPro}</t:Cell><t:Cell>$Resource{intentProductType}</t:Cell><t:Cell>$Resource{productDeatil}</t:Cell><t:Cell>$Resource{intentDirection}</t:Cell><t:Cell>$Resource{intentArea}</t:Cell><t:Cell>$Resource{intentSight}</t:Cell><t:Cell>$Resource{roomForm}</t:Cell><t:Cell>$Resource{intentRoomType}</t:Cell><t:Cell>$Resource{hopedUnitPrice}</t:Cell><t:Cell>$Resource{hopedTotalPrices}</t:Cell><t:Cell>$Resource{hopedFloor}</t:Cell><t:Cell>$Resource{buyHouseReason}</t:Cell><t:Cell>$Resource{hopedPitch}</t:Cell><t:Cell>$Resource{commerceIntention}</t:Cell><t:Cell>$Resource{intendingDate}</t:Cell><t:Cell>$Resource{intendingMoney}</t:Cell><t:Cell>$Resource{firstPayProportion}</t:Cell><t:Cell>$Resource{description}</t:Cell><t:Cell>$Resource{bargainOnCondition}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot> ";
		
        this.tblMain.setFormatXml(resHelper.translateString("tblMain",tblMainStrXML));
        this.tblMain.addKDTEditListener(new com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter() {
            public void editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) {
                try {
                    tblMain_editStopped(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });
                this.tblMain.putBindContents("mainQuery",new String[] {"","","","","","","","","","","","","","","","","","","","","","","","","","","",""});


        // contModifyCount		
        this.contModifyCount.setBoundLabelText(resHelper.getString("contModifyCount.boundLabelText"));		
        this.contModifyCount.setBoundLabelLength(100);		
        this.contModifyCount.setBoundLabelUnderline(true);
        // contSysType		
        this.contSysType.setBoundLabelText(resHelper.getString("contSysType.boundLabelText"));		
        this.contSysType.setBoundLabelLength(100);		
        this.contSysType.setBoundLabelUnderline(true);
        // comboSysType		
        this.comboSysType.setRequired(true);		
        this.comboSysType.addItems(EnumUtils.getEnumList("com.kingdee.eas.fdc.basedata.MoneySysTypeEnum").toArray());
        // contFilePath		
        this.contFilePath.setBoundLabelText(resHelper.getString("contFilePath.boundLabelText"));		
        this.contFilePath.setBoundLabelUnderline(true);		
        this.contFilePath.setBoundLabelLength(100);
        // contExcelTotalNum		
        this.contExcelTotalNum.setBoundLabelText(resHelper.getString("contExcelTotalNum.boundLabelText"));		
        this.contExcelTotalNum.setBoundLabelUnderline(true);		
        this.contExcelTotalNum.setBoundLabelLength(100);
        // contInvaluidCount		
        this.contInvaluidCount.setBoundLabelText(resHelper.getString("contInvaluidCount.boundLabelText"));		
        this.contInvaluidCount.setBoundLabelUnderline(true);		
        this.contInvaluidCount.setBoundLabelLength(100);
        // contAddNewCount		
        this.contAddNewCount.setBoundLabelText(resHelper.getString("contAddNewCount.boundLabelText"));		
        this.contAddNewCount.setBoundLabelLength(100);		
        this.contAddNewCount.setBoundLabelUnderline(true);
        // txtFilePath		
        this.txtFilePath.setEnabled(false);		
        this.txtFilePath.setEditable(false);
        // txtModifyCount		
        this.txtModifyCount.setPrecision(0);		
        this.txtModifyCount.setEditable(false);		
        this.txtModifyCount.setEnabled(false);
        // txtAddNewCount		
        this.txtAddNewCount.setPrecision(0);		
        this.txtAddNewCount.setEnabled(false);		
        this.txtAddNewCount.setEditable(false);
        // txtInvaluidCount		
        this.txtInvaluidCount.setPrecision(0);		
        this.txtInvaluidCount.setEditable(false);		
        this.txtInvaluidCount.setEnabled(false);
        // prmtSellProject		
        this.prmtSellProject.setRequired(true);		
        this.prmtSellProject.setQueryInfo("com.kingdee.eas.fdc.sellhouse.app.SellProjectQuery");		
        this.prmtSellProject.setDisplayFormat("$name$");		
        this.prmtSellProject.setEditFormat("$number$");		
        this.prmtSellProject.setCommitFormat("$number$");
        this.prmtSellProject.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtSellProject_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // contSellProject		
        this.contSellProject.setBoundLabelText(resHelper.getString("contSellProject.boundLabelText"));		
        this.contSellProject.setBoundLabelLength(100);		
        this.contSellProject.setBoundLabelUnderline(true);
        // txtExcelCount		
        this.txtExcelCount.setPrecision(0);		
        this.txtExcelCount.setEditable(false);		
        this.txtExcelCount.setEnabled(false);
        // btnExcelImport
        this.btnExcelImport.setAction((IItemAction)ActionProxyFactory.getProxy(actionExcelImport, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnExcelImport.setText(resHelper.getString("btnExcelImport.text"));		
        this.btnExcelImport.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_importexcel"));		
        this.btnExcelImport.setToolTipText(resHelper.getString("btnExcelImport.toolTipText"));
        // btnExcelSave
        this.btnExcelSave.setAction((IItemAction)ActionProxyFactory.getProxy(actionExcelSave, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnExcelSave.setText(resHelper.getString("btnExcelSave.text"));		
        this.btnExcelSave.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_save"));		
        this.btnExcelSave.setToolTipText(resHelper.getString("btnExcelSave.toolTipText"));
        // menuItemExcelImport
        this.menuItemExcelImport.setAction((IItemAction)ActionProxyFactory.getProxy(actionExcelImport, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemExcelImport.setText(resHelper.getString("menuItemExcelImport.text"));		
        this.menuItemExcelImport.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_importexcel"));		
        this.menuItemExcelImport.setToolTipText(resHelper.getString("menuItemExcelImport.toolTipText"));
        // menuItemExcelSave
        this.menuItemExcelSave.setAction((IItemAction)ActionProxyFactory.getProxy(actionExcelSave, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemExcelSave.setText(resHelper.getString("menuItemExcelSave.text"));		
        this.menuItemExcelSave.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_save"));		
        this.menuItemExcelSave.setToolTipText(resHelper.getString("menuItemExcelSave.toolTipText"));
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
        tblMain.setBounds(new Rectangle(9, 94, 996, 526));
        this.add(tblMain, new KDLayout.Constraints(9, 94, 996, 526, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contModifyCount.setBounds(new Rectangle(651, 61, 270, 19));
        this.add(contModifyCount, new KDLayout.Constraints(651, 61, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT));
        contSysType.setBounds(new Rectangle(14, 9, 270, 19));
        this.add(contSysType, new KDLayout.Constraints(14, 9, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT));
        contFilePath.setBounds(new Rectangle(14, 35, 584, 19));
        this.add(contFilePath, new KDLayout.Constraints(14, 35, 584, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT));
        contExcelTotalNum.setBounds(new Rectangle(651, 35, 270, 19));
        this.add(contExcelTotalNum, new KDLayout.Constraints(651, 35, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT));
        contInvaluidCount.setBounds(new Rectangle(14, 61, 270, 19));
        this.add(contInvaluidCount, new KDLayout.Constraints(14, 61, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT));
        contAddNewCount.setBounds(new Rectangle(328, 61, 270, 19));
        this.add(contAddNewCount, new KDLayout.Constraints(328, 61, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT));
        contSellProject.setBounds(new Rectangle(328, 9, 270, 19));
        this.add(contSellProject, new KDLayout.Constraints(328, 9, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT));
        //contModifyCount
        contModifyCount.setBoundEditor(txtModifyCount);
        //contSysType
        contSysType.setBoundEditor(comboSysType);
        //contFilePath
        contFilePath.setBoundEditor(txtFilePath);
        //contExcelTotalNum
        contExcelTotalNum.setBoundEditor(txtExcelCount);
        //contInvaluidCount
        contInvaluidCount.setBoundEditor(txtInvaluidCount);
        //contAddNewCount
        contAddNewCount.setBoundEditor(txtAddNewCount);
        //contSellProject
        contSellProject.setBoundEditor(prmtSellProject);

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
        menuEdit.add(menuItemExcelImport);
        menuEdit.add(menuItemExcelSave);
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
        this.toolBar.add(btnExcelImport);
        this.toolBar.add(btnExcelSave);


    }

	//Regiester control's property binding.
	private void registerBindings(){		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.fdc.sellhouse.app.CommerceChanceImportUIHandler";
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
     * output tblMain_editStopped method
     */
    protected void tblMain_editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception
    {
    }

    /**
     * output prmtSellProject_dataChanged method
     */
    protected void prmtSellProject_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
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
     * output actionExcelImport_actionPerformed method
     */
    public void actionExcelImport_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionExcelSave_actionPerformed method
     */
    public void actionExcelSave_actionPerformed(ActionEvent e) throws Exception
    {
    }
	public RequestContext prepareActionExcelImport(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionExcelImport() {
    	return false;
    }
	public RequestContext prepareActionExcelSave(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionExcelSave() {
    	return false;
    }

    /**
     * output ActionExcelImport class
     */     
    protected class ActionExcelImport extends ItemAction {     
    
        public ActionExcelImport()
        {
            this(null);
        }

        public ActionExcelImport(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionExcelImport.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionExcelImport.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionExcelImport.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCommerceChanceImportUI.this, "ActionExcelImport", "actionExcelImport_actionPerformed", e);
        }
    }

    /**
     * output ActionExcelSave class
     */     
    protected class ActionExcelSave extends ItemAction {     
    
        public ActionExcelSave()
        {
            this(null);
        }

        public ActionExcelSave(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            _tempStr = resHelper.getString("ActionExcelSave.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionExcelSave.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionExcelSave.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCommerceChanceImportUI.this, "ActionExcelSave", "actionExcelSave_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.fdc.sellhouse.client", "CommerceChanceImportUI");
    }




}