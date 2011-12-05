/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\Users\\Mareli\\workspace\\nanicolina-shsim\\AndEngineUbicompTest\\src\\br\\uff\\ic\\ubicomp\\testes\\knowledge\\IMyResourceService.aidl
 */
package br.uff.ic.ubicomp.testes.knowledge;
public interface IMyResourceService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements br.uff.ic.ubicomp.testes.knowledge.IMyResourceService
{
private static final java.lang.String DESCRIPTOR = "br.uff.ic.ubicomp.testes.knowledge.IMyResourceService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an br.uff.ic.ubicomp.testes.knowledge.IMyResourceService interface,
 * generating a proxy if needed.
 */
public static br.uff.ic.ubicomp.testes.knowledge.IMyResourceService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof br.uff.ic.ubicomp.testes.knowledge.IMyResourceService))) {
return ((br.uff.ic.ubicomp.testes.knowledge.IMyResourceService)iin);
}
return new br.uff.ic.ubicomp.testes.knowledge.IMyResourceService.Stub.Proxy(obj);
}
public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_createResource:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
float _arg3;
_arg3 = data.readFloat();
float _arg4;
_arg4 = data.readFloat();
this.createResource(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
return true;
}
case TRANSACTION_getResource:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getResource();
reply.writeNoException();
reply.writeString(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements br.uff.ic.ubicomp.testes.knowledge.IMyResourceService
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
public void createResource(java.lang.String name, java.lang.String id, int onOff, float x, float y) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(name);
_data.writeString(id);
_data.writeInt(onOff);
_data.writeFloat(x);
_data.writeFloat(y);
mRemote.transact(Stub.TRANSACTION_createResource, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
public java.lang.String getResource() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getResource, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_createResource = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_getResource = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
}
public void createResource(java.lang.String name, java.lang.String id, int onOff, float x, float y) throws android.os.RemoteException;
public java.lang.String getResource() throws android.os.RemoteException;
}
